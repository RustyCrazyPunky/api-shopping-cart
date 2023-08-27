package com.mlt.api.apishoppingcart.domain.dto.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mlt.api.common.domain.response.MltData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO extends MltData {

    @NotBlank(message = "productId is required")
    private String productId;
    @NotNull(message = "quantity is required")
    private Integer quantity;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long itemId;

}
