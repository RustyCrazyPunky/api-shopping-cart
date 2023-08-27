package com.mlt.api.apishoppingcart.domain.dto.data;

import com.mlt.api.common.domain.response.MltData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoppingCartDTO extends MltData {

    private Long shoppingCartId;
    private List<ItemDTO> items;
    private boolean closed;

}
