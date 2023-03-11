package com.h2.kong2.yogurt.domain;

import com.h2.kong2.config.QuerydslConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({QuerydslConfiguration.class})
@ActiveProfiles("test")
class YogurtRepositoryTest {
    @Autowired
    YogurtRepository yogurtRepository;

    @Test
    void 요거트_생성_테스트() {
        Yogurt yogurt = Yogurt.builder()
                .name("테스트요거트")
                .price(5000)
                .build();

        Yogurt testYogurt = yogurtRepository.save(yogurt);

        assertEquals(testYogurt.getName(), yogurt.getName());
        assertEquals(testYogurt.getPrice(), yogurt.getPrice());
    }
}
