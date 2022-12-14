package com.payhere.accountbook.exception;

import com.payhere.accountbook.domain.SpecificExceptionCode;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public class NotExistMemberException extends CustomException {

	public NotExistMemberException() {
		super(SpecificExceptionCode.NOT_EXIST_MEMBER_EXCEPTION);
	}

}
