package com.h2.kong2.yogurt.domain.dto;

import com.h2.kong2.yogurt.domain.Yogurt;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface YogurtMapper {
    List<YogurtDto> toDTOList(List<Yogurt> yogurtEntityList);
}
