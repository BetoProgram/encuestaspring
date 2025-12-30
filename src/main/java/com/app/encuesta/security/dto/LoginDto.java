package com.app.encuesta.security.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @NotBlank(message = "El username no puede ser vacio")
    private String username;

    @NotBlank(message = "El password no puede ser vacio")
    private String password;
}
