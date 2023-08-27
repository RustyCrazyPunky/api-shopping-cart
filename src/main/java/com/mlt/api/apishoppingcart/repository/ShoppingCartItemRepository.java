package com.mlt.api.apishoppingcart.repository;

import com.mlt.api.apishoppingcart.model.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
}
