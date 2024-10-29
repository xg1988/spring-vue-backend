package com.chosu.springvue01.util;

import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    public Cookie addCookie(String key, String value){
        // 쿠키에 JWT 저장
        Cookie cookie = new Cookie(key, value);
        cookie.setHttpOnly(false); // JavaScript에서 접근 불가
        cookie.setSecure(false); // HTTPS에서만 전송
        cookie.setPath("/"); // 모든 경로에서 접근 가능
        cookie.setMaxAge(86400); // 1일 유효기간

        return cookie;
    }

    public String getJwtFromCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) { // 쿠키 이름을 JWT 토큰 이름으로 설정
                    return cookie.getValue();
                }
            }
        }
        return null; // 쿠키가 없거나 토큰이 없을 경우
    }

}
