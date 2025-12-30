package com.app.encuesta.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String username;
    private String email;

    private List<RoleDto> roles;
}
