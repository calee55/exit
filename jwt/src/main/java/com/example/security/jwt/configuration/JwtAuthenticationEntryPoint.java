package com.example.security.jwt.configuration;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//인증 실패 시
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
 @Override
 public void commence(HttpServletRequest request,
                      HttpServletResponse response,
                      AuthenticationException authException) throws IOException, java.io.IOException {
     // 유효한 자격증명을 제공하지 않고 접근하려 할때 401(인증 실패)
     response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
 }
}