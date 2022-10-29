package com.payhere.accountbook.exception;

import com.payhere.accountbook.domain.SpecificExceptionCode;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public class ExistAccountBookException extends CustomException {

	public ExistAccountBookException() {
		super(SpecificExceptionCode.EXIST_ACCOUNT_BOOK_EXCEPTION);
	}

}
