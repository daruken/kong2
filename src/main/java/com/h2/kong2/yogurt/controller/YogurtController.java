package com.h2.kong2.yogurt.controller;

import com.h2.kong2.yogurt.domain.dto.YogurtDto;
import com.h2.kong2.yogurt.service.YogurtQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/yogurts")
public class YogurtController {
    YogurtQueryService yogurtQueryService;

    public YogurtController(YogurtQueryService yogurtQueryService) {
        this.yogurtQueryService = yogurtQueryService;
    }

    @GetMapping("")
    public List<YogurtDto> getYogurtList() {
        return yogurtQueryService.selectAll();
    }
}
