package com.payhere.accountbook.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.payhere.accountbook.domain.dto.AuthenticatedUser;
import com.payhere.accountbook.domain.enntity.Member;
import com.payhere.accountbook.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
@RequiredArgsConstructor
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByMemberEmail(username);
		AuthenticatedUser user = new AuthenticatedUser();
		return user;
	}
}
