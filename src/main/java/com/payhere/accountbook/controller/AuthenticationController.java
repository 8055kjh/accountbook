package com.payhere.accountbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payhere.accountbook.domain.dto.AuthenticationRequestDto;
import com.payhere.accountbook.exception.UnauthorizedException;
import com.payhere.accountbook.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<?> authentication(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws UnauthorizedException{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(authenticationService.login(authenticationRequestDto));
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
	}
}
