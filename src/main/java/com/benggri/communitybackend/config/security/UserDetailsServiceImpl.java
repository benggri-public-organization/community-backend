package com.benggri.communitybackend.config.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.benggri.communitybackend.model.entity.member.MemberEntity;
import com.benggri.communitybackend.model.vo.auth.CustomUserDetailsVo;
import com.benggri.communitybackend.model.vo.member.MemberVo;
import com.benggri.communitybackend.service.auth.AuthService;
import com.benggri.communitybackend.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthService authService;

    @Override
    public CustomUserDetailsVo loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<MemberEntity> optMemberEntity = authService.findByEmail(email);
        if (!optMemberEntity.isPresent()) {
            throw new UsernameNotFoundException("존재하지 않는 회원입니다");
        }
        MemberEntity memberEntity = optMemberEntity.get();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(memberEntity.getEmail());
        return new CustomUserDetailsVo(memberEntity, memberEntity.getPassword(),
                Collections.singleton(grantedAuthority));
    }

}
