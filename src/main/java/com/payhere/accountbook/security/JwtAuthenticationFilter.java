package com.payhere.accountbook.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-29
 * JwtTokenProvider가 검증을 끝낸 Jwt로부터 회원정보를 조회해와서 UserPasswordAuthenticationFilter 로 전달
 */
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

	private final JwtTokenProvider jwtTokenProvider;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException, ServletException {
		String token = jwtTokenProvider.resolveToken((HttpServletRequest)request);
		String requestURI = ((HttpServletRequest)request).getRequestURI();
		if (token != null && jwtTokenProvider.validateToken(token)) {
			Authentication authentication = jwtTokenProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} else {
			log.info("invalid jwt token , uri: {}", requestURI);
		}
		chain.doFilter(request, response);
	}
}
