package com.chosu.springvue01.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * permit all api pattern
     * @return
     */
    @GetMapping("/test")
    public String test1(){
        return "simple test";
    }

    /**
     * spring security filter
     * @return
     */
    @GetMapping("/api/test")
    public String test2(){
        return "spring security test";
    }
}
