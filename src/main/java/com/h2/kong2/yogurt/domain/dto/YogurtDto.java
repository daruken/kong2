package com.h2.kong2.yogurt.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class YogurtDto {
    private Long id;
    private String name;
    private int price;
}
