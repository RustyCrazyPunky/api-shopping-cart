package com.mlt.api.apishoppingcart.service.impl;

import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import com.mlt.api.apishoppingcart.mapper.ShoppingCartMapper;
import com.mlt.api.apishoppingcart.model.ShoppingCart;
import com.mlt.api.apishoppingcart.model.ShoppingCartUser;
import com.mlt.api.apishoppingcart.repository.ShoppingCartRepository;
import com.mlt.api.apishoppingcart.repository.ShoppingCartUserRepository;
import com.mlt.api.apishoppingcart.service.ShoppingCartService;
import com.mlt.api.common.handler.error.exception.validation.IdsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository cartRepository;
    private final ShoppingCartUserRepository userRepository;
    private final ShoppingCartMapper cartMapper;

    @Override
    public ShoppingCartDTO getShoppingCart(Long id) {
        return cartMapper.toDTO(cartRepository.findById(id)
                                              .orElseThrow(() -> IdsNotFoundException.builder(
                                                                                             "id",
                                                                                             List.of(id.toString())
                                                                                     )
                                                                                     .build()));
    }

    @Override
    public ShoppingCartDTO closeShoppingCart(Long id) {
        ShoppingCart cart = cartRepository.findByIdAndClosed(id, false)
                                          .orElseThrow(() -> IdsNotFoundException.builder("id", List.of(id.toString()))
                                                                                 .build());
        cart.setClosed(true);
        cartRepository.save(cart);
        return cartMapper.toDTO(cart);
    }

    @Override
    public ShoppingCartDTO obtainForUser(String username) {
        ShoppingCartUser cartUser = userRepository.findByUsernameAndShoppingCartClosed(username, false)
                                                  .orElseGet(() -> {
                                                      ShoppingCartUser user = ShoppingCartUser.builder()
                                                                                              .username(username)
                                                                                              .build();
                                                      user.setShoppingCart(ShoppingCart.builder()
                                                                                       .shoppingCartUser(user)
                                                                                       .shoppingCartItems(List.of())
                                                                                       .closed(false)
                                                                                       .build());
                                                      userRepository.save(user);
                                                      return user;
                                                  });
        return cartMapper.toDTO(cartUser.getShoppingCart());
    }
}