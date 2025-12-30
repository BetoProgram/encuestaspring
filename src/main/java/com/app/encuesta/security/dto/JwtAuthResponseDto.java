package com.app.encuesta.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";

    public JwtAuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
