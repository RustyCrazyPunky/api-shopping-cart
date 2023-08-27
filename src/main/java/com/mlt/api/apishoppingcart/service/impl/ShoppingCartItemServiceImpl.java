package com.mlt.api.apishoppingcart.service.impl;

import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import com.mlt.api.apishoppingcart.domain.dto.request.body.AddItemsRequest;
import com.mlt.api.apishoppingcart.domain.dto.request.query.RemoveItemsQueryParams;
import com.mlt.api.apishoppingcart.mapper.ShoppingCartMapper;
import com.mlt.api.apishoppingcart.model.ShoppingCart;
import com.mlt.api.apishoppingcart.model.ShoppingCartItem;
import com.mlt.api.apishoppingcart.repository.ShoppingCartItemRepository;
import com.mlt.api.apishoppingcart.repository.ShoppingCartRepository;
import com.mlt.api.apishoppingcart.service.ShoppingCartItemService;
import com.mlt.api.common.handler.error.exception.validation.IdsNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

    private final ShoppingCartRepository cartRepository;
    private final ShoppingCartItemRepository itemRepository;
    private final ShoppingCartMapper cartMapper;

    @Override
    public ShoppingCartDTO addItems(Long id, AddItemsRequest request) {
        ShoppingCart cart = cartRepository.findByIdAndClosed(id, false)
                                          .orElseThrow(() -> IdsNotFoundException.builder("id", List.of(id.toString()))
                                                                                 .build());
        List<ShoppingCartItem> actualItems = cart.getShoppingCartItems();
        request.getItems().forEach(
                item ->
                        actualItems.stream()
                                   .filter(i -> i.getProductId().equals(item.getProductId()))
                                   .findAny()
                                   .ifPresentOrElse(
                                           i -> {
                                               i.setQuantity(i.getQuantity() + item.getQuantity());
                                               itemRepository.save(i);
                                           },
                                           () -> actualItems.add(itemRepository.save(
                                                   ShoppingCartItem.builder()
                                                                   .shoppingCart(cart)
                                                                   .productId(item.getProductId())
                                                                   .quantity(item.getQuantity())
                                                                   .build()
                                           ))
                                   )

        );
        return cartMapper.toDTO(cart);
    }

    @Override
    @Transactional
    public ShoppingCartDTO removeItems(Long id, RemoveItemsQueryParams request) {
        ShoppingCart cart = cartRepository.findByIdAndClosed(id, false)
                                          .orElseThrow(() -> IdsNotFoundException.builder("id", List.of(id.toString()))
                                                                                 .build());
        List<ShoppingCartItem> actualItems = cart.getShoppingCartItems();
        request.getIds().forEach(
                item ->
                        actualItems.stream()
                                   .filter(i -> i.getId().equals(item))
                                   .findAny()
                                   .ifPresent(i -> {
                                       itemRepository.delete(i);
                                       actualItems.remove(i);
                                   })
        );
        return cartMapper.toDTO(cart);
    }
}
