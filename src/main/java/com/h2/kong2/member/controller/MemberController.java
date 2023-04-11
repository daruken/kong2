package com.h2.kong2.member.controller;

import com.h2.kong2.member.domain.dto.MemberDto;
import com.h2.kong2.member.domain.dto.SignInDto;
import com.h2.kong2.member.domain.dto.SignInResultDto;
import com.h2.kong2.member.domain.dto.SignUpDto;
import com.h2.kong2.member.service.MemberCommandService;
import com.h2.kong2.member.service.MemberQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    MemberCommandService memberCommandService;
    MemberQueryService memberQueryService;

    @Autowired
    public MemberController(MemberCommandService memberCommandService, MemberQueryService memberQueryService) {
        this.memberCommandService = memberCommandService;
        this.memberQueryService = memberQueryService;
    }

    @GetMapping("")
    public Page<MemberDto> getMemberList(Pageable pageable) {
        return memberQueryService.selectAll(pageable);
    }

    @PostMapping("/sign-up")
    public MemberDto signUp(@RequestBody @Validated SignUpDto signUpDto) {
        return memberCommandService.signUp(signUpDto);
    }

    @GetMapping("/sign-in")
    public String signInDummy() {
        return "";
    }

    @PostMapping("/sign-in")
    public SignInResultDto signIn(@RequestBody SignInDto signInDto) {
        return memberCommandService.signIn(signInDto);
    }
}
