package com.benggri.communitybackend.model.vo.board.post;

import java.util.List;

import com.benggri.communitybackend.model.vo.common.PaginationVo;
import com.benggri.communitybackend.model.vo.common.ReqVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "게시글 조회 요청 Vo")
public class BoardPostReqVo extends ReqVo {

    @Schema(description = "게시판_IDX")
    private Long boardIdx;
    @Schema(description = "게시글_제목")
    private String title;
    @Schema(description = "작성자_email")
    private String memberEmail;
    @Schema(description = "작성자_닉네임")
    private String memberNickname;

}
