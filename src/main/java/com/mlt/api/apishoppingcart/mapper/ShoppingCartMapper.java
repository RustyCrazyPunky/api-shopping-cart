package com.mlt.api.apishoppingcart.mapper;

import com.mlt.api.apishoppingcart.domain.dto.data.ShoppingCartDTO;
import com.mlt.api.apishoppingcart.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ShoppingCartItemMapper.class})
public abstract class ShoppingCartMapper {

    @Mapping(target = "shoppingCartId", source = "cart.id")
    @Mapping(target = "closed", source = "cart.closed")
    @Mapping(target = "items", source = "cart.shoppingCartItems")
    public abstract ShoppingCartDTO toDTO(ShoppingCart cart);

}
