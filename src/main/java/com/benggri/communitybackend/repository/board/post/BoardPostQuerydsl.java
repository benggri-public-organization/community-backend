package com.benggri.communitybackend.repository.board.post;

import static com.benggri.communitybackend.utils.QueryUtil.getOrderByList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.benggri.communitybackend.model.entity.board.QBoardEntity;
import com.benggri.communitybackend.model.entity.board.post.QBoardPostEntity;
import com.benggri.communitybackend.model.entity.member.QMemberEntity;
import com.benggri.communitybackend.model.vo.board.post.BoardPostReqVo;
import com.benggri.communitybackend.model.vo.board.post.BoardPostVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardPostQuerydsl {

    private final JPAQueryFactory jpaQueryFactory;
    private QBoardEntity qBoardEntity = QBoardEntity.boardEntity;
    private QBoardPostEntity qBoardPostEntity = QBoardPostEntity.boardPostEntity;
    private QMemberEntity qMemberEntity = QMemberEntity.memberEntity;
    private Map<String, EntityPathBase> orderByMap = new HashMap<String, EntityPathBase>() {
        {
            put("idx", qBoardEntity);
            put("regDate", qBoardEntity);
        }
    };

    // @Transactional
    public List findList(BoardPostReqVo reqVo) {
        List<BoardPostVo> result = jpaQueryFactory.select(
                Projections.bean(
                        BoardPostVo.class,
                        qBoardPostEntity.idx,
                        qBoardPostEntity.boardIdx,
                        qBoardEntity.boardName,
                        qBoardPostEntity.memberIdx,
                        qMemberEntity.email.as("memberEmail"),
                        qMemberEntity.nickname.as("memberNickname"),
                        qBoardPostEntity.title,
                        // qBoardPostEntity.contents,
                        qBoardPostEntity.regDate))
                .from(qBoardPostEntity)
                .join(qBoardEntity)
                .on(qBoardPostEntity.boardIdx.eq(qBoardEntity.idx))
                .join(qMemberEntity)
                .on(qBoardPostEntity.memberIdx.eq(qMemberEntity.idx))
                .where(getConditions(reqVo))
                .offset(reqVo.getOffset())
                .limit(reqVo.getLimit())
                .orderBy(getOrderByList(orderByMap, reqVo))
                .fetch();
        return result;
    }

    public Long findListTotCnt(BoardPostReqVo reqVo) {
        Long result = jpaQueryFactory.select(qBoardPostEntity.count())
                .from(qBoardPostEntity)
                .join(qBoardEntity)
                .on(qBoardPostEntity.boardIdx.eq(qBoardEntity.idx))
                .join(qMemberEntity)
                .on(qBoardPostEntity.memberIdx.eq(qMemberEntity.idx))
                .where(getConditions(reqVo))
                .fetchOne();
        return result;
    }

    @Transactional
    public BoardPostVo findOne(Long postIdx) {
        BoardPostVo result = jpaQueryFactory.select(
                Projections.bean(
                        BoardPostVo.class,
                        qBoardPostEntity.idx,
                        qBoardPostEntity.boardIdx,
                        qBoardEntity.boardName,
                        qBoardPostEntity.memberIdx,
                        qMemberEntity.email.as("memberEmail"),
                        qMemberEntity.nickname.as("memberNickname"),
                        qBoardPostEntity.title,
                        qBoardPostEntity.contents,
                        qBoardPostEntity.regDate))
                .from(qBoardPostEntity)
                .join(qBoardEntity)
                .on(qBoardPostEntity.boardIdx.eq(qBoardEntity.idx))
                .join(qMemberEntity)
                .on(qBoardPostEntity.memberIdx.eq(qMemberEntity.idx))
                .where(qBoardPostEntity.idx.eq(postIdx))
                .fetchOne();
        return result;

    }

    private BooleanBuilder getConditions(BoardPostReqVo reqVo) {
        BooleanBuilder builder = new BooleanBuilder();
        if (!ObjectUtils.isEmpty(reqVo.getBoardIdx())) {
            builder.and(qBoardPostEntity.boardIdx.eq(reqVo.getBoardIdx()));
        }
        if (!ObjectUtils.isEmpty(reqVo.getTitle())) {
            builder.and(qBoardPostEntity.title.like("%" + reqVo.getTitle() + "%"));
        }
        if (!ObjectUtils.isEmpty(reqVo.getMemberEmail())) {
            builder.and(qMemberEntity.email.like("%" + reqVo.getMemberEmail() + "%"));
        }
        if (!ObjectUtils.isEmpty(reqVo.getMemberNickname())) {
            builder.and(qMemberEntity.nickname.like("%" + reqVo.getMemberNickname() + "%"));
        }
        return builder;
    }
}
