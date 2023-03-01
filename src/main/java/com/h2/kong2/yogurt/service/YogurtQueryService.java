package com.h2.kong2.yogurt.service;

import com.h2.kong2.yogurt.domain.YogurtRepository;
import com.h2.kong2.yogurt.domain.dto.YogurtDto;
import com.h2.kong2.yogurt.domain.dto.YogurtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YogurtQueryService {
    YogurtMapper yogurtMapper;
    YogurtRepository yogurtRepository;

    @Autowired
    public YogurtQueryService(YogurtMapper yogurtMapper, YogurtRepository yogurtRepository) {
        this.yogurtMapper = yogurtMapper;
        this.yogurtRepository = yogurtRepository;
    }

    public List<YogurtDto> selectAll() {
        return yogurtMapper.toDTOList(yogurtRepository.findAll());
    }
}
