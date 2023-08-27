package com.mlt.api.apishoppingcart.repository;

import com.mlt.api.apishoppingcart.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
