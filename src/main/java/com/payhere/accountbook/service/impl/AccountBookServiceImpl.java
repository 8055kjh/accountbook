package com.payhere.accountbook.service.impl;

import org.springframework.stereotype.Service;

import com.payhere.accountbook.domain.dto.reqeust.AccountBookRegisterDto;
import com.payhere.accountbook.domain.enntity.AccountBook;
import com.payhere.accountbook.exception.ExistAccountBookException;
import com.payhere.accountbook.repository.AccountBookRepository;
import com.payhere.accountbook.service.AccountBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountBookServiceImpl implements AccountBookService {

	private final AccountBookRepository accountBookRepository;

	@Override
	public void registerAccountBook(AccountBookRegisterDto dto, Long memberNo) {
		accountBookRepository.findByAccountBookName(dto.getAccountBookName())
			.ifPresent(user -> {
				throw new ExistAccountBookException();
			});
		AccountBook accountBook = new AccountBook();
		accountBook.setAccountBookName(dto.getAccountBookName());
		accountBook.setDeleteYn('N');
		accountBook.setMemo(dto.getMemo());

		accountBookRepository.save(accountBook);
	}
}
