package com.mlt.api.apishoppingcart.repository;

import com.mlt.api.apishoppingcart.model.ShoppingCartUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartUserRepository extends JpaRepository<ShoppingCartUser, Long> {
}
