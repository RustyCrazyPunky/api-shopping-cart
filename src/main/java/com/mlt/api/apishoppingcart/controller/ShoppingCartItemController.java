package com.mlt.api.apishoppingcart.controller;

import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import com.mlt.api.apishoppingcart.domain.dto.request.body.AddItemsRequest;
import com.mlt.api.apishoppingcart.domain.dto.request.query.RemoveItemsQueryParams;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/shopping-carts/{id}/items")
@Validated
public interface ShoppingCartItemController {

    @PostMapping
    ShoppingCartDTO addItems(@PathVariable Long id, @RequestBody @Valid AddItemsRequest request);

    @DeleteMapping
    ShoppingCartDTO removeItems(@PathVariable Long id, @Valid RemoveItemsQueryParams request);

}
