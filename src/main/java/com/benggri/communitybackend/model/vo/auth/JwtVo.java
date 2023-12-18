package com.benggri.communitybackend.model.vo.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Jwt Vo")
public class JwtVo {

    @Schema(description = "Email")
    private String email;
    @Schema(description = "닉네임")
    private String nickname;
    @Schema(description = "멤버_타입")
    private String memberType;
    @Schema(description = "Grant Type")
    private String grantType;
    @Schema(description = "Access Token")
    private String accessToken;
    @Schema(description = "Refresh Token")
    private String refreshToken;
    @Schema(description = "Access Token Expires In")
    private long accessTokenExpiresIn;

}
