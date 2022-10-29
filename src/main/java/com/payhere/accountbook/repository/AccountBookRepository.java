package com.payhere.accountbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payhere.accountbook.domain.enntity.AccountBook;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@Repository
public interface AccountBookRepository extends JpaRepository<AccountBook, Long> {
	Optional<AccountBook> findByAccountBookName(String accountBookName);
}
