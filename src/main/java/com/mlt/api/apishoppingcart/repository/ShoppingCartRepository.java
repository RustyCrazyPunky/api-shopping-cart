package com.mlt.api.apishoppingcart.repository;

import com.mlt.api.apishoppingcart.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByIdAndClosed(Long id, Boolean closed);

}
