package com.h2.kong2.member.domain;

import com.h2.kong2.config.QuerydslConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({QuerydslConfiguration.class})
@ActiveProfiles("test")
class MemberTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입_테스트() {
        Member test = Member.builder()
                .name("test")
                .password("0000")
                .email("test@gmail.com")
                .createdDate(LocalDateTime.of(2023, 3, 11, 16, 54))
                .updatedDate(LocalDateTime.of(2023, 3, 11, 16, 54))
                .build();

        Member member = memberRepository.save(test);

        assertEquals(member.getName(), test.getName());
        assertEquals(member.getPassword(), test.getPassword());
        assertEquals(member.getEmail(), test.getEmail());
        assertEquals(member.getCreatedDate(), test.getCreatedDate());
        assertEquals(member.getUpdatedDate(), test.getUpdatedDate());
    }
}