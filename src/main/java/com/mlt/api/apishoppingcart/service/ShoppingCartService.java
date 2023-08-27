package com.mlt.api.apishoppingcart.service;

import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;

public interface ShoppingCartService {

    ShoppingCartDTO getShoppingCart(Long id);


    ShoppingCartDTO closeShoppingCart(Long id);

    ShoppingCartDTO obtainForUser(String username);

}
