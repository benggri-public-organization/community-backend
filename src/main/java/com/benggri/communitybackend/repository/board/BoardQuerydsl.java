package com.benggri.communitybackend.repository.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.benggri.communitybackend.model.entity.board.QBoardEntity;
import com.benggri.communitybackend.model.vo.board.BoardVo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardQuerydsl {

    private final JPAQueryFactory jpaQueryFactory;
    private QBoardEntity qBoardEntity = QBoardEntity.boardEntity;

    public List findList() {
        List<BoardVo> result = jpaQueryFactory.select(
                Projections.bean(
                        BoardVo.class,
                        qBoardEntity.idx,
                        qBoardEntity.boardName,
                        qBoardEntity.boardDesc,
                        qBoardEntity.sortBy))
                .from(qBoardEntity)
                .orderBy(qBoardEntity.sortBy.asc())
                .fetch();
        return result;
    }
}
