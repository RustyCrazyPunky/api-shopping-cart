package com.mlt.api.apishoppingcart.domain.dto.request.query;

import com.mlt.api.common.domain.request.MltQueryParams;
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
public class RemoveItemsQueryParams extends MltQueryParams {

    private List<Long> ids;

}
