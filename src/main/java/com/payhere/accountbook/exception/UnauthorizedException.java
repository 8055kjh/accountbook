package com.payhere.accountbook.exception;

import com.payhere.accountbook.domain.SpecificExceptionCode;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public class UnauthorizedException extends CustomException {

	public UnauthorizedException(SpecificExceptionCode notExistMemberException) {
		super(notExistMemberException);
	}
}
