package com.h2.kong2.member.domain;

import com.h2.kong2.member.domain.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomMemberRepository {
    Page<MemberDto> findAllMembers(Pageable pageable);
    boolean existsByName(String name);
}
