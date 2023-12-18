package com.benggri.communitybackend.model.vo.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.benggri.communitybackend.model.entity.member.MemberEntity;
import com.benggri.communitybackend.model.vo.member.MemberVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetailsVo extends User {

    protected Long idx;
    protected String email;
    protected String membername;
    protected String nickname;
    protected String memberType;

    public CustomUserDetailsVo(Long idx, String email, String nickname, String password,
            Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.idx = idx;
        this.email = email;
        this.nickname = nickname;
    }

    public CustomUserDetailsVo(MemberEntity memberEntity, String password,
            Collection<? extends GrantedAuthority> authorities) {
        super(memberEntity.getEmail(), password, authorities);
        this.idx = memberEntity.getIdx();
        this.email = memberEntity.getEmail();
        this.nickname = memberEntity.getNickname();
    }

}
