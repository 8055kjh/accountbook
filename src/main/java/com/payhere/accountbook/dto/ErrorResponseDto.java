package com.payhere.accountbook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
@Getter
@Setter
@Builder
public class ErrorResponseDto {
	private String msg;
	private Object data;

	public ErrorResponseDto(String msg, Object data) {
		this.msg = msg;
		this.data = data;
	}
}
