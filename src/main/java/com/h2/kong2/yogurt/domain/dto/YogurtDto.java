package com.h2.kong2.yogurt.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class YogurtDto {
    private final Long id;
    private final String name;
    private final int price;

    @QueryProjection
    public YogurtDto(
            Long id,
            String name,
            int price
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
