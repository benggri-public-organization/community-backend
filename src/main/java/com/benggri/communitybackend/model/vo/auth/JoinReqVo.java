package com.benggri.communitybackend.model.vo.auth;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.benggri.communitybackend.model.entity.member.MemberEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "회원가입 요청 VO")
public class JoinReqVo {
    @Column(unique = true)
    @Schema(description = "이메일")
    private String email;
    @Schema(description = "닉네임")
    private String nickname;
    @Schema(description = "비밀번호")
    private String password;
    @Schema(description = "멤버 타입")
    private String memberType;

    @Column(nullable = false)
    @CreationTimestamp
    @Convert(converter = LocalDateTimeConverter.class)
    @Schema(description = "가입 일")
    private LocalDateTime joinDate;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    @Convert(converter = LocalDateTimeConverter.class)
    @Schema(description = "요청 일")
    private LocalDateTime reqDate;

    public MemberEntity toMemberEntity(PasswordEncoder passwordEncoder) {
        return MemberEntity.builder()
                .email(this.email)
                .nickname(this.nickname)
                .memberType("MEMBER")
                .build();
    }
}
