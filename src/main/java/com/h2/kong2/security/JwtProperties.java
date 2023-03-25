package com.h2.kong2.security;

public class JwtProperties {
    public static final long tokenValidMillisecond = 1000L * 60 * 60;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
