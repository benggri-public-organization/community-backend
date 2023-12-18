package com.benggri.communitybackend.controller.auth;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benggri.communitybackend.config.exception.BadRequestException;
import com.benggri.communitybackend.config.jwt.JwtProvider;
import com.benggri.communitybackend.model.entity.member.MemberEntity;
import com.benggri.communitybackend.model.vo.auth.JoinReqVo;
import com.benggri.communitybackend.model.vo.auth.JwtVo;
import com.benggri.communitybackend.model.vo.auth.LoginReqVo;
import com.benggri.communitybackend.model.vo.member.MemberVo;
import com.benggri.communitybackend.service.auth.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtProvider jwtProvider;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Operation(summary = "회원 정보 생성", description = "회원 정보 생성")
    @PostMapping("join")
    public ResponseEntity join(@RequestBody JoinReqVo joinReqVo) throws Exception {
        MemberEntity memberEntity = joinReqVo.toMemberEntity(passwordEncoder);
        MemberVo resVo = authService.createMember(memberEntity);
        return ResponseEntity.ok().body(resVo);
    }

    @Operation(summary = "회원 로그인", description = "회원 로그인")
    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginReqVo loginReqVo) {
        try {
            Authentication authentication = authenticationManagerBuilder.getObject()
                    .authenticate(new UsernamePasswordAuthenticationToken(loginReqVo.getEmail(),
                            loginReqVo.getPassword()));
            Optional<MemberEntity> optMemberEntity = authService.findByEmail(loginReqVo.getEmail());
            if (!optMemberEntity.isPresent()) {
                throw new BadRequestException("올바르지 않은 로그인 정보입니다");
            }
            MemberEntity memberEntity = optMemberEntity.get();
            JwtVo tokenVo = jwtProvider.generateToken(authentication, memberEntity);
            return ResponseEntity.ok().body(tokenVo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("Authentication Failed");
        }
    }

}
