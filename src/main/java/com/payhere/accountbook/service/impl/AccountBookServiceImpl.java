package com.payhere.accountbook.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payhere.accountbook.domain.dto.reqeust.AccountBookRegisterDto;
import com.payhere.accountbook.domain.dto.reqeust.AccountBookUpdateDto;
import com.payhere.accountbook.domain.enntity.AccountBook;
import com.payhere.accountbook.exception.ExistAccountBookException;
import com.payhere.accountbook.exception.NotExistAccountBookException;
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

	private final Character deleteYn = 'Y';
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

	@Override
	public List<AccountBook> getAccountBookList(Long memberNo) {
		return accountBookRepository.findAllByMemberNo(memberNo).orElse(null);
	}

	@Override
	public AccountBook getAccountBook(Long accountBookNo) {
		return accountBookRepository.findByAccountBookNoAndDeleteYn(accountBookNo, deleteYn).orElse(null);
	}

	@Override
	public AccountBook updateAccountBook(Long accountBookNo, AccountBookUpdateDto accountBookUpdateDto) {
		return accountBookRepository.findByAccountBookNoAndDeleteYn(accountBookNo, deleteYn)
			.map(accountBook -> {
				accountBook.setAccountBookName(accountBookUpdateDto.getAccountBookName());
				accountBook.setMemo(accountBookUpdateDto.getMemo());
				return accountBookRepository.save(accountBook);
			}).orElseThrow(NotExistAccountBookException::new);
	}

	@Override
	public AccountBook deleteAccountBook(Long accountBookNo) {
		return accountBookRepository.findByAccountBookNo(accountBookNo)
			.map(accountBook -> {
				accountBook.setDeleteYn('Y');
				return accountBookRepository.save(accountBook);
			}).orElseThrow(NotExistAccountBookException::new);
	}
}
