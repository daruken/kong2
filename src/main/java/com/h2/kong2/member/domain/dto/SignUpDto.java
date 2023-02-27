package com.h2.kong2.member.domain.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class SignUpDto {
    String name;
    String password;
    @Email
    String email;
}
