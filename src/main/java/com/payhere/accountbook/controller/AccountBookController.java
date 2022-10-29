package com.payhere.accountbook.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payhere.accountbook.domain.dto.AuthenticatedUser;
import com.payhere.accountbook.domain.dto.reqeust.AccountBookRegisterDto;
import com.payhere.accountbook.service.AccountBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account-book")
public class AccountBookController {

	private final AccountBookService accountBookService;

	//가계부 등록
	@PostMapping
	public ResponseEntity<?> registerAccountBook(@Valid @RequestBody AccountBookRegisterDto accountBookRegisterDto, @AuthenticationPrincipal AuthenticatedUser user) {
		accountBookService.registerAccountBook(accountBookRegisterDto, user.getMemberNo());
		return ResponseEntity.ok().build();
	}
	//가계부 목록 조회
	@GetMapping
	public ResponseEntity<?> getAccountBookList() {
		return ResponseEntity.ok().body(accountBookService.getAccountBookList());
	}

	//가계부 조회
	@GetMapping("/{accountBookNo}")
	public ResponseEntity<?> getAccountBook(@PathVariable Long accountBookNo) {
		return ResponseEntity.ok().body(accountBookService.getAccountBook(accountBookNo));
	}
	// - [ ]  가계부 수정: PUT /api/account-book/{id}
}
