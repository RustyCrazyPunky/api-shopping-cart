package com.mlt.api.apishoppingcart.domain.dto.request.body;

import com.mlt.api.apishoppingcart.domain.dto.data.ItemDTO;
import com.mlt.api.common.domain.request.MltRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddItemsRequest extends MltRequest {

    @NotEmpty(message = "items cannot be empty")
    private List<@Valid ItemDTO> items;

}
