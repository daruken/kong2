package com.h2.kong2.yogurt.service;

import com.h2.kong2.redis.RedissonLockYogurtFacade;
import com.h2.kong2.yogurt.domain.Yogurt;
import com.h2.kong2.yogurt.domain.YogurtRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
@ActiveProfiles("test")
class YogurtCommandServiceTest {
    @Autowired
    RedissonLockYogurtFacade redissonLockYogurtFacade;

    @Autowired
    YogurtRepository yogurtRepository;

    @Test
    void 요거트_재고_테스트() throws InterruptedException {
        Yogurt yogurt = Yogurt.builder()
                .id(1L)
                .name("테스트요거트")
                .price(5000)
                .quantity(100L)
                .build();

        yogurtRepository.save(yogurt);

        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    redissonLockYogurtFacade.decrease(1L, 1L);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        Yogurt resultYogurt = yogurtRepository.findById(1L).orElseThrow();

        assertEquals(resultYogurt.getQuantity(), 0L);
    }
}