package com.nguyenhuuvu.backend.config.filter;

import com.nguyenhuuvu.backend.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
    final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie cookie = WebUtils.getCookie(request, "token");
        String requestToken = null;
        if (cookie != null) {
            requestToken = cookie.getValue();
        }
        boolean expire = true;

        if (requestToken != null) {
            try {
                expire = jwtTokenUtil.isTokenExpired(requestToken);
                if (!expire && SecurityContextHolder.getContext().getAuthentication() == null) {
                    Authentication authentication = jwtTokenUtil.getAuthentication(requestToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                log.error("token fail {}", e.getMessage());
                e.printStackTrace();
            }
        }

        filterChain.doFilter(request, response);
    }
}
