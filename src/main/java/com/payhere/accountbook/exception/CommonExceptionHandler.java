package com.payhere.accountbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.payhere.accountbook.dto.ErrorResponseDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException e) {
		ErrorResponseDto errorResponseDto = ErrorResponseDto
			.builder()
			.msg(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
			.build();
		return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.BAD_REQUEST);
	}
}
