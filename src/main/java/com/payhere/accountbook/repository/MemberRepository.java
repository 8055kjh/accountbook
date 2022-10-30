package com.payhere.accountbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payhere.accountbook.domain.enntity.Member;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByMemberEmail(String email);

	Optional<Member> findAccountBookListByMemberNo(Long memberNo);

	Optional<Member> findByMemberNo(Long memberNo);
}
