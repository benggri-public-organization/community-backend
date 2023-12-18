package com.benggri.communitybackend.service.board.post;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.benggri.communitybackend.model.entity.board.post.BoardPostEntity;
import com.benggri.communitybackend.model.vo.board.post.BoardPostReqVo;
import com.benggri.communitybackend.model.vo.board.post.BoardPostVo;
import com.benggri.communitybackend.model.vo.common.ResVo;
import com.benggri.communitybackend.repository.board.post.BoardPostJpa;
import com.benggri.communitybackend.repository.board.post.BoardPostQuerydsl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardPostService {
    private final BoardPostJpa boardPostJpa;
    private final BoardPostQuerydsl boardPostQuerydsl;

    public ResVo findList(BoardPostReqVo reqVo) {
        Long totCnt = boardPostQuerydsl.findListTotCnt(reqVo);
        reqVo.pagination(totCnt);
        List list = boardPostQuerydsl.findList(reqVo);
        return reqVo.toResVo(list);
    }

    public BoardPostVo insert(BoardPostVo reqVo) {
        BoardPostEntity entity = BoardPostEntity.builder()
                .boardIdx(reqVo.getBoardIdx())
                .memberIdx(reqVo.getMemberIdx())
                .title(reqVo.getTitle())
                .contents(reqVo.getContents())
                .regDate(LocalDateTime.now()).build();
        boardPostJpa.save(entity);
        reqVo.setIdx(entity.getIdx());
        return reqVo;
    }

    public BoardPostVo findOne(Long postIdx) {
        return boardPostQuerydsl.findOne(postIdx);
    }
}
