package com.h2.kong2.yogurt.service;

import com.h2.kong2.yogurt.domain.Yogurt;
import com.h2.kong2.yogurt.domain.YogurtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class YogurtCommandService {
    private final YogurtRepository yogurtRepository;

    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        Yogurt yogurt = yogurtRepository.findById(id).orElseThrow();
        yogurt.decrease(quantity);
        yogurtRepository.save(yogurt);
    }
}
