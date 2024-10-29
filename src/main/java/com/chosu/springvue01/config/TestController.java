package com.chosu.springvue01.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    /**
     * permit all api pattern
     * @return
     */
    @GetMapping("/test")
    public String test1(){
        log.info("test1 called");
        return "simple test";
    }

    /**
     * spring security filter
     * @return
     */
    @GetMapping("/api/test")
    public String test2(){
        log.info("test2 called");
        return "spring security test";
    }

    @GetMapping("/api/test3")
    public HashMap test3(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("test", "test");

        return map;
    }
}
