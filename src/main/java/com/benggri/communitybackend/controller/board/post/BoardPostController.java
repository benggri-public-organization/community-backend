package com.benggri.communitybackend.controller.board.post;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.benggri.communitybackend.model.vo.auth.CustomUserDetailsVo;
import com.benggri.communitybackend.model.vo.board.BoardVo;
import com.benggri.communitybackend.model.vo.board.post.BoardPostReqVo;
import com.benggri.communitybackend.model.vo.board.post.BoardPostVo;
import com.benggri.communitybackend.service.board.post.BoardPostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("board/post")
@RequiredArgsConstructor
public class BoardPostController {
    private final BoardPostService boardPostService;

    @GetMapping("{boardIdx}")
    public ResponseEntity findList(
            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(name = "pagePerCount", defaultValue = "5") int pagePerCount,
            @RequestParam(name = "orderByColumns", defaultValue = "idx") String[] orderByColumns,
            @RequestParam(name = "orderByDirections", defaultValue = "desc") String[] orderByDirections,
            @PathVariable Long boardIdx) {
        return ResponseEntity.ok().body(boardPostService.findList(BoardPostReqVo.builder()
                .boardIdx(boardIdx)
                .pageNo(pageNo)
                .pagePerCount(pagePerCount)
                .orderByColumns(orderByColumns)
                .orderByDirections(orderByDirections)
                .build()));
    }

    @PostMapping("{boardIdx}")
    public ResponseEntity insert(
            @PathVariable Long boardIdx,
            @RequestBody BoardPostVo reqVo,
            @AuthenticationPrincipal CustomUserDetailsVo customUserDetails) {
        reqVo.setBoardIdx(boardIdx);
        reqVo.setMemberIdx(customUserDetails.getIdx());
        return ResponseEntity.ok().body(boardPostService.insert(reqVo));
    }

    @GetMapping("{boardIdx}/{postIdx}")
    public ResponseEntity findOne(
            @PathVariable Long boardIdx,
            @PathVariable Long postIdx) {
        return ResponseEntity.ok().body(boardPostService.findOne(postIdx));

    }
}
