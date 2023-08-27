package com.mlt.api.apishoppingcart.controller;

import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/shopping-carts")
@Validated
public interface ShoppingCartController {


    @GetMapping("/{id}")
    ShoppingCartDTO getShoppingCart(@PathVariable Long id);


    @PutMapping("/{id}")
    ShoppingCartDTO closeShoppingCart(@PathVariable Long id);

    @PostMapping
    ShoppingCartDTO obtainForUser(@Valid @NotBlank(message = "username is required") String username);

}
