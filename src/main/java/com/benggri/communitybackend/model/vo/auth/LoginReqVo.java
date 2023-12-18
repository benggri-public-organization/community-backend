package com.benggri.communitybackend.model.vo.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "로그인 요청 VO")
public class LoginReqVo {
    @Schema(description = "로그인 요청 Email", example = "admin01@benggri.com")
    private String email;
    @Schema(description = "로그인 요청 비밀번호", example = "qwer1234")
    private String password;
}
