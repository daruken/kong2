package com.h2.kong2.member.domain.dto;

import lombok.Builder;

@Builder
public record SignInResultDto(
        boolean isLogin,
        String token
) {
}
