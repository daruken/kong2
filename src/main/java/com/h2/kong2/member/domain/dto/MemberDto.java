package com.h2.kong2.member.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @QueryProjection
    public MemberDto(
            Long id,
            String name,
            String email,
            LocalDateTime createdDate,
            LocalDateTime updatedDate
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
