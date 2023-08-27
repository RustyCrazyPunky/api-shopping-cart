package com.mlt.api.apishoppingcart.repository;

import com.mlt.api.apishoppingcart.model.ShoppingCartUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartUserRepository extends JpaRepository<ShoppingCartUser, Long> {

    Optional<ShoppingCartUser> findByUsernameAndShoppingCartClosed(String username, Boolean closed);

}
