package com.benggri.communitybackend.model.vo.board.post;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "게시글 Vo")
public class BoardPostVo {
    @Schema(description = "물리 PK")
    private Long idx;

    @Schema(description = "게시판_IDX")
    private Long boardIdx;

    @Schema(description = "게시판_명")
    private String boardName;

    @Schema(description = "작성자")
    private Long memberIdx;

    @Schema(description = "작성자_Email")
    private String memberEmail;

    @Schema(description = "작성자_닉네임")
    private String memberNickname;

    @Schema(description = "제목")
    private String title;

    @Schema(description = "내용")
    private String contents;

    @Schema(description = "작성 일")
    private LocalDateTime regDate;

}
