package com.benggri.communitybackend.model.vo.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "게시판 VO")
public class BoardVo {
    @Schema(description = "물리 PK")
    private Long idx;
    @Schema(description = "게시판_명")
    private String boardName;
    @Schema(description = "게시판_설명")
    private String boardDesc;
    @Schema(description = "표시_순서")
    private Integer sortBy;
}
