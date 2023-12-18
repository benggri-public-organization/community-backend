package com.benggri.communitybackend.model.vo.common;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "공통 요청 Vo")
public class ReqVo extends PaginationVo {

    private LocalDateTime reqTime;

    public ResVo toResVo(List data) {
        return ResVo.builder()
                .totalCount(getTotalCount())
                .pageNo(getPageNo())
                .pagePerCount(getPagePerCount())
                .totalPage(getTotalPage())
                .startPage(getStartPage())
                .endPage(getEndPage())
                .pages(getPages())
                .data(data)
                .build();
    }
}
