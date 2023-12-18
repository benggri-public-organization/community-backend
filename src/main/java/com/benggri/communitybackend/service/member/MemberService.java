package com.benggri.communitybackend.service.member;

import org.springframework.stereotype.Service;

import com.benggri.communitybackend.model.vo.member.MemberVo;
import com.benggri.communitybackend.repository.member.MemberQuerydsl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberQuerydsl memberQuerydsl;

    public MemberVo findByEmail(String email) {
        return memberQuerydsl.findByEmail(email);
    }
}
