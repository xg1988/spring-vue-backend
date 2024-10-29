package com.chosu.springvue01.domain.user.controller;

import com.chosu.springvue01.domain.user.dto.UserSignUpDto;
import com.chosu.springvue01.domain.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oauth")
@Slf4j
public class OauthController {

    private final UserService userService;

    public OauthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public Map<String, Object> signUp(@RequestBody UserSignUpDto userSignUpDto){
        HashMap<String, Object> map = new HashMap<>();
        String resultCode = "";
        String resultMessage = "";
        try{

            log.info("user : {}" , userSignUpDto);

            userService.updateUserRole(userSignUpDto);

            resultCode = "0000";
            resultMessage = "";
        }catch (Exception e){
            resultCode = "1000";
            resultMessage = e.getMessage();
        }


        map.put("resultCode", resultCode);
        map.put("resultMessage", resultMessage);

        return map;
    }
}
