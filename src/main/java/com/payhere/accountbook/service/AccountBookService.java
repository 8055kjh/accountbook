package com.payhere.accountbook.service;

import com.payhere.accountbook.domain.dto.reqeust.AccountBookRegisterDto;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public interface AccountBookService {
	void registerAccountBook(AccountBookRegisterDto accountBookRegisterDto, Long memberNo);
}
