package com.mlt.api.apishoppingcart.controller.impl;

import com.mlt.api.apishoppingcart.controller.ShoppingCartController;
import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import com.mlt.api.apishoppingcart.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingCartControllerImpl implements ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Override
    public ShoppingCartDTO getShoppingCart(Long id) {
        return shoppingCartService.getShoppingCart(id);
    }

    @Override
    public ShoppingCartDTO closeShoppingCart(Long id) {
        return shoppingCartService.closeShoppingCart(id);
    }

    @Override
    public ShoppingCartDTO obtainForUser(String username) {
        return shoppingCartService.obtainForUser(username);
    }


}
