package com.benggri.communitybackend.repository.member;

import org.springframework.stereotype.Repository;

import com.benggri.communitybackend.model.entity.member.QMemberEntity;
import com.benggri.communitybackend.model.vo.member.MemberVo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberQuerydsl {

    private final JPAQueryFactory jpaQueryFactory;
    private QMemberEntity qMemberEntity = QMemberEntity.memberEntity;

    public MemberVo findByEmail(String email) {
        MemberVo result = jpaQueryFactory.select(
                Projections.bean(
                        MemberVo.class,
                        qMemberEntity.idx,
                        qMemberEntity.email,
                        qMemberEntity.password,
                        qMemberEntity.nickname,
                        qMemberEntity.password,
                        qMemberEntity.memberType,
                        qMemberEntity.joinDate,
                        qMemberEntity.reqDate))
                .from(qMemberEntity)
                .where(qMemberEntity.email.eq(email))
                .fetchOne();
        return result;
    }

}
