package com.h2.kong2.yogurt.controller;

import com.h2.kong2.yogurt.domain.dto.YogurtDto;
import com.h2.kong2.yogurt.domain.dto.YogurtSearchDto;
import com.h2.kong2.yogurt.service.YogurtQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/search")
    public Page<YogurtDto> searchYogurt(@PageableDefault(size = 10, sort = "username") Pageable pageable, @RequestBody YogurtSearchDto yogurtSearchDto) {
        return yogurtQueryService.selectAllByCondition(pageable, yogurtSearchDto);
    }
}
