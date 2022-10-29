package com.payhere.accountbook.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.payhere.accountbook.domain.dto.MemberSignUpDto;
import com.payhere.accountbook.domain.enntity.Member;
import com.payhere.accountbook.exception.ExistMemberException;
import com.payhere.accountbook.repository.MemberRepository;
import com.payhere.accountbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public Member signUp(MemberSignUpDto memberSignUpDto) {

		boolean isExist = isExistMember(memberSignUpDto);
		Member memberEntity = new Member();
		if(isExist) {
			memberEntity.setMemberName(memberSignUpDto.getName());
			memberEntity.setMemberEmail(memberSignUpDto.getEmail());
			memberEntity.setMemberPassword(memberSignUpDto.getPassword());
			memberEntity.setMemberSignupDate(LocalDateTime.now());
			return memberRepository.save(memberEntity);
		}
		return memberEntity;
	}


	@Override
	public boolean isExistMember(MemberSignUpDto memberSignUpDto) {
		Member member = memberRepository.findByMemberEmail(memberSignUpDto.getEmail());
		if(member != null) {
			throw new ExistMemberException();
		}
		return true;
	}


}
