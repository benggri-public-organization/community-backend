package com.benggri.communitybackend.repository.board.post;

import org.springframework.stereotype.Repository;

import com.benggri.communitybackend.model.entity.board.post.QBoardPostCommentEntity;
import com.benggri.communitybackend.model.entity.member.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardPostCommentQeury {

    private final JPAQueryFactory jpaQueryFactory;
    private QBoardPostCommentEntity qBoardPostCommentEntity = QBoardPostCommentEntity.boardPostCommentEntity;
    private QMemberEntity qMemberEntity = QMemberEntity.memberEntity;


}
