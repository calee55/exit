package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.provider.JwtTokenProvider;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BaseController {

	 private final JwtTokenProvider jwtTokenProvider;
	 private final UserRepository userRepository;
	    
	 final String EMAIL = "aabbcc@gmail.com";
	    
	 User user = User.builder()
	            .email(EMAIL)
	            .build();
	 
	 @PostMapping("/join")
	    public String join(){
	        log.info("로그인 시도됨");

	        userRepository.save(user);

	        return user.toString();

	    }

	    // 로그인
	    @PostMapping("/login")
	    public String login(@RequestBody Map<String, String> user) {
	        log.info("user email = {}", user.get("email"));
	        User member = userRepository.findByEmail(user.get("email"))
	                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));

	        return jwtTokenProvider.createToken(member.getUsername(), Collections.singletonList("ROLE_USER"));
	    }
}
