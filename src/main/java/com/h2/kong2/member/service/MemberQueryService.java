package com.h2.kong2.member.service;

import com.h2.kong2.member.domain.MemberRepository;
import com.h2.kong2.member.domain.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberQueryService {
    MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Page<MemberDto> selectAll(Pageable pageable) {
        return memberRepository.findAllMembers(pageable);
    }
}
