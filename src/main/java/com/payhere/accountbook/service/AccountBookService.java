package com.payhere.accountbook.service;

import java.util.List;

import com.payhere.accountbook.domain.dto.reqeust.AccountBookRegisterDto;
import com.payhere.accountbook.domain.enntity.AccountBook;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public interface AccountBookService {
	void registerAccountBook(AccountBookRegisterDto accountBookRegisterDto, Long memberNo);

	List<AccountBook> getAccountBookList();

	AccountBook getAccountBook(Long accountBookNo);
}

