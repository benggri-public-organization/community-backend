package com.benggri.communitybackend.model.vo.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderByVo {

    @Schema(description = "정렬 기준 컬럼")
    private String orderByColumn;
    @Schema(description = "정렬 기준(asc, desc)")
    private String orderByDirection;

}
