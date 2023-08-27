package com.mlt.api.apishoppingcart.mapper;

import com.mlt.api.apishoppingcart.domain.dto.data.ItemDTO;
import com.mlt.api.apishoppingcart.model.ShoppingCartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ShoppingCartItemMapper {

    @Mapping(target = "itemId", source = "item.id")
    public abstract ItemDTO toDTO(ShoppingCartItem item);

}
