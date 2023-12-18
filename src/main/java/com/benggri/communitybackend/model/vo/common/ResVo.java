package com.benggri.communitybackend.model.vo.common;

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
@Schema(description = "공통 응답 VO")
public class ResVo extends PaginationVo {
    @Schema(description = "응답 VO List")
    List data;
}
