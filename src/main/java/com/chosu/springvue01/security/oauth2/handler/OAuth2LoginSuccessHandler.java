package com.chosu.springvue01.security.oauth2.handler;

import com.chosu.springvue01.domain.user.Role;
import com.chosu.springvue01.security.jwt.service.JwtService;
import com.chosu.springvue01.security.oauth2.CustomOAuth2User;
import com.chosu.springvue01.util.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;

@Slf4j
@Component
@RequiredArgsConstructor
//@Transactional
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final CookieUtil cookieUtil;
//    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 Login 성공!");
        try {
            CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

            // User의 Role이 GUEST일 경우 처음 요청한 회원이므로 회원가입 페이지로 리다이렉트

            log.info("OAuth2 Login oAuth2User.getRole(): {}" , oAuth2User.getRole());

            if(oAuth2User.getRole() == Role.GUEST) {

                String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
                log.info("OAuth2 Login accessToken: {}" , accessToken);
                String refreshToken = jwtService.createRefreshToken();

                response.addCookie(cookieUtil.addCookie("accessToken", accessToken));
                response.addCookie(cookieUtil.addCookie("refreshToken", refreshToken));

                //response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
                response.sendRedirect("/oauth/sign-up"); // 프론트의 회원가입 추가 정보 입력 폼으로 리다이렉트

                jwtService.sendAccessAndRefreshToken(response, accessToken, null);
//                User findUser = userRepository.findByEmail(oAuth2User.getEmail())
//                                .orElseThrow(() -> new IllegalArgumentException("이메일에 해당하는 유저가 없습니다."));
//                findUser.authorizeUser();
            } else {
                loginSuccess(response, oAuth2User); // 로그인에 성공한 경우 access, refresh 토큰 생성
                response.sendRedirect("/"); // 프론트의 회원가입 추가 정보 입력 폼으로 리다이렉트
            }
        } catch (Exception e) {
            log.info("oauth error:{}", e.getMessage());
            throw e;
        }

    }

    // TODO : 소셜 로그인 시에도 무조건 토큰 생성하지 말고 JWT 인증 필터처럼 RefreshToken 유/무에 따라 다르게 처리해보기
    // TODO: 가지고 있는 엑세스 토큰으로 접근하면 되는것 아닌지.. 프로세스를 다시 정리 필요, 뭔가 로그인 이후에 공통 되는 handler 가 있어야할 것 같음
    private void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
        String refreshToken = jwtService.createRefreshToken();
        response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
        response.addHeader(jwtService.getRefreshHeader(), "Bearer " + refreshToken);

        response.addCookie(cookieUtil.addCookie("accessToken", accessToken));
        response.addCookie(cookieUtil.addCookie("refreshToken", refreshToken));

        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);
        jwtService.updateRefreshToken(oAuth2User.getEmail(), refreshToken);
    }
}
