package com.payhere.accountbook.security;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
// 토큰을 생성하고 검증하는 클래스입니다.
// 해당 컴포넌트는 필터클래스에서 사전 검증을 거칩니다.
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
	private String secretKey = "payhereaccountbook";

	private final UserDetailsService userDetailsService;

	// 객체 초기화, secretKey를 Base64로 인코딩한다.
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	/**
	 * JWT 토큰 생성
	 * @param userPk
	 * @return
	 */
	public String createToken(String userPk) {
		long tokenValidTime = 10 * 60 * 1000L;// 토큰 유효시간 1분
		Claims claims = Jwts.claims().setSubject(userPk); // JWT payload 에 저장되는 정보단위, 보통 여기서 user를 식별하는 값을 넣는다.
		Date now = new Date();
		return Jwts.builder()
			.setClaims(claims) // 정보 저장
			.setIssuedAt(now) // 토큰 발행 시간 정보
			.setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
			.signWith(SignatureAlgorithm.HS256, secretKey)  // 사용할 암호화 알고리즘과
			// signature 에 들어갈 secret값 세팅
			.compact();
	}

	/**
	 * JWT 토큰에서 인증 정보 조회
	 * @param token
	 * @return
	 */
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "");
	}

	/**
	 * 토큰에서 회원 정보 추출
	 * @param token
	 * @return
	 */
	public String getUserPk(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * Request의 Header에서 token 값을 가져옵니다. "Authorization" : "TOKEN값'
	 * @param request
	 * @return
	 */
	public String resolveToken(HttpServletRequest request) {
		return request.getHeader("Authorization");
	}

	/**
	 * 토큰의 유효성 + 만료일자 확인
	 * @param jwtToken
	 * @return
	 */
	public boolean validateToken(String jwtToken) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
			return !claims.getBody().getExpiration().before(new Date());
		} catch (Exception e) {
			return false;
		}
	}
}