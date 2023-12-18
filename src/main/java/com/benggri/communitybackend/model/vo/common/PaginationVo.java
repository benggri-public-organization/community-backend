package com.benggri.communitybackend.model.vo.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.benggri.communitybackend.utils.PaginationUtil.calcPage;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "공통 페이지네이션 Vo")
public class PaginationVo {
    @Schema(description = "총 건수")
    private Long totalCount;
    @Schema(description = "페이지 번호")
    private Integer pageNo;
    @Schema(description = "페이지 당 표시 건수")
    private Integer pagePerCount;
    @Schema(description = "전체 페이지 수")
    private Integer totalPage;
    @Schema(description = "시작 페이지 번호")
    private Integer startPage;
    @Schema(description = "끝 페이지 번호")
    private Integer endPage;
    @Schema(description = "페이지 목록")
    private List<Integer> pages;
    @Schema(description = "정렬 기준 - 컬럼")
    private String[] orderByColumns;
    @Schema(description = "정렬 기준 - 방향")
    private String[] orderByDirections;
    @Schema(description = "정렬 기준")
    private List<OrderByVo> orderByVos;

    @JsonIgnore
    private Integer offset;
    @JsonIgnore
    private Integer limit;

    public List<OrderByVo> getOrderByVos() {
        List<OrderByVo> result = new ArrayList<OrderByVo>();
        if (!ObjectUtils.isEmpty(this.orderByColumns)) {
            for (int i = 0; i < this.orderByColumns.length; i++) {
                String direction = ((i + 1) < this.orderByDirections.length) ? this.orderByDirections[i] : "desc";
                result.add(OrderByVo.builder()
                        .orderByColumn(this.orderByColumns[i])
                        .orderByDirection(direction)
                        .build());
            }
        }
        return result;
    }

    public void pagination(Long totalCount) {
        this.totalCount = totalCount;
        pagination();
    }

    public void pagination() {
        PaginationVo paginationVo = calcPage(this.totalCount, this.pageNo, this.pagePerCount);
        this.totalCount = paginationVo.getTotalCount();
        this.pageNo = paginationVo.getPageNo();
        this.pagePerCount = paginationVo.getPagePerCount();
        this.totalPage = paginationVo.getTotalPage();
        this.startPage = paginationVo.getStartPage();
        this.endPage = paginationVo.getEndPage();
        this.pages = paginationVo.getPages();
    }

    public Integer getOffset() {
        return (this.pageNo - 1) * this.pagePerCount;
    }

    public Integer getLimit() {
        return this.pagePerCount;
    }

}
