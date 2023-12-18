package com.benggri.communitybackend.model.vo.member;

import java.time.LocalDateTime;

import com.benggri.communitybackend.model.entity.member.MemberEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "회원 정보 Vo")
public class MemberVo {
    @Schema(description = "물리 PK")
    private Long idx;
    @Schema(description = "이메일")
    private String email;
    @Schema(description = "닉네임")
    private String nickname;
    @Schema(description = "멤버_타입")
    private String memberType;
    @Schema(description = "가입 일")
    private LocalDateTime joinDate;
    @Schema(description = "요청 일")
    private LocalDateTime reqDate;

    public MemberEntity toMemberEntity(String password) {
        return MemberEntity.builder()
                .email(this.email)
                .nickname(this.nickname)
                .password(password)
                .idx(this.idx)
                .joinDate(this.joinDate)
                .reqDate(this.reqDate)
                .build();
    }

}
