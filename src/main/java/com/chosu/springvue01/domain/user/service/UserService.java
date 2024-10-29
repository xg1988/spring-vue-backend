package com.chosu.springvue01.domain.user.service;

import com.chosu.springvue01.domain.user.Role;
import com.chosu.springvue01.domain.user.User;
import com.chosu.springvue01.domain.user.dto.UserSignUpDto;
import com.chosu.springvue01.domain.user.repository.UserRepository;
import com.chosu.springvue01.security.jwt.service.JwtService;
import com.chosu.springvue01.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CookieUtil cookieUtil;
    private final JwtService jwtService;

    public void signUp(HttpServletRequest request, UserSignUpDto userSignUpDto) throws Exception {
        log.info("userSignUpDto : {}", userSignUpDto);

        if("Y".equals(userSignUpDto.getIsOAuth())){
            updateUserRole(request);
        }else {
            userSignUp(userSignUpDto);
        }
    }

    private void userSignUp(UserSignUpDto userSignUpDto) throws Exception {
        if (userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if (userRepository.findByNickname(userSignUpDto.getNickname()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        User user = User.builder()
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .nickname(userSignUpDto.getNickname())
                .age(userSignUpDto.getAge())
                .city(userSignUpDto.getCity())
                .role(Role.USER)
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }

    public void updateUserRole(HttpServletRequest request){
        String accessToken  = cookieUtil.getJwtFromCookies(request.getCookies());
        log.info("accessToken : {}", accessToken);

        String email = jwtService.extractEmail(accessToken).get();
        log.info("email : {}", email);

        User user = userRepository.findByEmail(email).get();
        user.updateRole(Role.USER);
        userRepository.save(user);
    }

    public Map<String, String> getUserInfo(String userId){
        User user = userRepository.findByEmail(userId).orElseThrow();

        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("city", user.getCity());
        userInfo.put("nickname", user.getNickname());
        userInfo.put("image_url", user.getImageUrl());
        userInfo.put("email", user.getEmail());
        userInfo.put("age", String.valueOf(user.getAge()));
        //userInfo.put("social_type", user.getSocialType().name());

        return userInfo;
    }
}


