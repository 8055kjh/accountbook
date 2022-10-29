package com.payhere.accountbook.exception;

import com.payhere.accountbook.domain.SpecificExceptionCode;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public class ExistMemberException extends CustomException {

	public ExistMemberException() {
		super(SpecificExceptionCode.EXIST_MEMBER_EXCEPTION);
	}

}
