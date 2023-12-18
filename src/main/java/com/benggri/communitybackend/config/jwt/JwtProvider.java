package com.benggri.communitybackend.config.jwt;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.benggri.communitybackend.model.entity.member.MemberEntity;
import com.benggri.communitybackend.model.vo.auth.CustomUserDetailsVo;
import com.benggri.communitybackend.model.vo.auth.JwtVo;
import com.benggri.communitybackend.model.vo.member.MemberVo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 10; // 10일
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 10; // 10일

    private String secret = "secretKeysecretKeysecretKeysecretKeysecretKeysecretKeysecretKeysecretKeysecretKeysecretKey";
    private final SecretKey key;

    public JwtProvider() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public JwtVo generateToken(Authentication authentication, MemberEntity memberEntity) {
        long now = (new Date()).getTime();
        // Access Token
        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        String accessToken = Jwts.builder()
                .subject(authentication.getName())
                .claims(Map.of("membername", authentication.getName(), "email", memberEntity.getEmail(), "idx",
                        memberEntity.getIdx()))
                .expiration(accessTokenExpiresIn)
                .signWith(key).compact();

        // refresh Token
        Date refreshTokenExpiresIn = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);
        String refreshToken = Jwts.builder().subject(authentication.getName())
                .claims(Map.of("membername", authentication.getName(), "email", memberEntity.getEmail(), "idx",
                        memberEntity.getIdx(), "nickname", memberEntity.getNickname()))
                .expiration(refreshTokenExpiresIn)
                .signWith(key).compact();

        return JwtVo.builder()
                .email(memberEntity.getEmail())
                .nickname(memberEntity.getNickname())
                .memberType(memberEntity.getMemberType())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiresIn(accessTokenExpiresIn.getTime())
                .build();
    }

    public Authentication getAuthentication(String accessToken) {
        // Token 복호화
        Claims claims = parseClaims(accessToken);

        // UserDetails 객체 만들어서 Authentication 리턴
        String membername = (ObjectUtils.isEmpty(claims.get("membername"))) ? "" : claims.get("membername").toString();
        String email = (ObjectUtils.isEmpty(claims.get("email"))) ? "" : claims.get("email").toString();
        String nickname = (ObjectUtils.isEmpty(claims.get("nickname"))) ? "" : claims.get("nickname").toString();
        Long idx = (ObjectUtils.isEmpty(claims.get("idx"))) ? null : Long.valueOf(claims.get("idx").toString());
        CustomUserDetailsVo principal = new CustomUserDetailsVo(idx, email, membername, "", Arrays.asList());
        principal.setIdx(idx);
        principal.setEmail(email);
        principal.setMembername(membername);
        principal.setNickname(nickname);
        return new UsernamePasswordAuthenticationToken(principal, "", Arrays.asList());
    }

    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            System.out.println("잘못된 JWT 서명");
        } catch (ExpiredJwtException e) {
            System.out.println("만료된 JWT");
        } catch (UnsupportedJwtException e) {
            System.out.println("지원되지 않는 JWT");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 JWT");
        }
        return false;
    }

    public Claims parseClaims(String accessToken) {
        try {
            return Jwts.parser().verifyWith(key).build().parseSignedClaims(accessToken)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
