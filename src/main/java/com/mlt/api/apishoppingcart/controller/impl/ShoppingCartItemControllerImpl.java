package com.mlt.api.apishoppingcart.controller.impl;

import com.mlt.api.apishoppingcart.controller.ShoppingCartItemController;
import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import com.mlt.api.apishoppingcart.domain.dto.request.body.AddItemsRequest;
import com.mlt.api.apishoppingcart.domain.dto.request.query.RemoveItemsQueryParams;
import com.mlt.api.apishoppingcart.service.ShoppingCartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingCartItemControllerImpl implements ShoppingCartItemController {

    private final ShoppingCartItemService itemService;

    @Override
    public ShoppingCartDTO addItems(Long id, AddItemsRequest request) {
        return itemService.addItems(id, request);
    }

    @Override
    public ShoppingCartDTO removeItems(Long id, RemoveItemsQueryParams request) {
        return itemService.removeItems(id, request);
    }
}
