package com.chosu.springvue01.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class VIewController {

    @GetMapping(value = {"/", "/login", "/main", "/bookmark", "/menu", "/oauth/sign-up", "/sign-up"})
    public String index(HttpServletRequest request){
        log.info("index called!! : {}" , request.getRequestURI());
        return "/index.html";
    }
}
