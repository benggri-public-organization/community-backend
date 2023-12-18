package com.benggri.communitybackend.service.auth;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.benggri.communitybackend.model.entity.member.MemberEntity;
import com.benggri.communitybackend.model.vo.member.MemberVo;
import com.benggri.communitybackend.repository.member.MemberJpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberJpa memberJpa;

    public Optional<MemberEntity> findByEmail(String email) {
        return memberJpa.findByEmail(email);
    }

    public MemberVo createMember(MemberEntity memberEntity) {
        memberJpa.save(memberEntity);
        return MemberVo.builder()
                .idx(memberEntity.getIdx())
                .email(memberEntity.getEmail())
                .nickname(memberEntity.getNickname())
                .memberType(memberEntity.getMemberType())
                .joinDate(memberEntity.getJoinDate())
                .reqDate(memberEntity.getReqDate())
                .build();
    }

}
