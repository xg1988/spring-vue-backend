package com.chosu.springvue01.domain.user.controller;

import com.chosu.springvue01.domain.user.dto.UserSignUpDto;
import com.chosu.springvue01.domain.user.service.UserService;
import com.chosu.springvue01.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public String signUp(HttpServletRequest request, @RequestBody UserSignUpDto userSignUpDto) throws Exception {
        userService.signUp(request, userSignUpDto);
        return "회원가입 성공";
    }

    @GetMapping("/jwt-test")
    public String jwtTest() {
        return "jwtTest 요청 성공";
    }

    @GetMapping("/user-info")
    public Map<String, String> getUserInfo(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("userId: {}" , userId);
        return userService.getUserInfo(userId);
    }
}
