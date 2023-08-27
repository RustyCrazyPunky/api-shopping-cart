package com.mlt.api.apishoppingcart.service;

import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import com.mlt.api.apishoppingcart.domain.dto.request.body.AddItemsRequest;
import com.mlt.api.apishoppingcart.domain.dto.request.query.RemoveItemsQueryParams;

public interface ShoppingCartItemService {

    ShoppingCartDTO addItems(Long id, AddItemsRequest request);

    ShoppingCartDTO removeItems(Long id, RemoveItemsQueryParams request);

}
