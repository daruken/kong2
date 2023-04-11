package com.h2.kong2.member.domain.dto;

import jakarta.validation.constraints.Email;

public record SignUpDto(
        String username,
        String password,
        @Email String email
) {
}
