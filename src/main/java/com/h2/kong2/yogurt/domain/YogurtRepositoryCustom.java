package com.h2.kong2.yogurt.domain;

import com.h2.kong2.yogurt.domain.dto.YogurtDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface YogurtRepositoryCustom {
    Page<YogurtDto> findYogurtByCondition(Pageable pageable, String condition);
}
