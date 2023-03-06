package com.h2.kong2.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @GetMapping("/test2")
    public String test2() {
        return "홍텐의 개인 서비스입니다.";
    }
}
