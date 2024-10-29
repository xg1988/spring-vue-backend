package com.chosu.springvue01.domain.user.service;

import com.chosu.springvue01.domain.user.Role;
import com.chosu.springvue01.domain.user.User;
import com.chosu.springvue01.domain.user.dto.UserSignUpDto;
import com.chosu.springvue01.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpDto userSignUpDto) throws Exception {

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

    public void updateUserRole(UserSignUpDto userSignUpDto){
        User user = userRepository.findByEmail(userSignUpDto.getEmail()).orElseThrow(RuntimeException::new);
        user.updateRole(Role.USER);
        userRepository.save(user);
    }
}


