package com.payhere.accountbook.service;

import com.payhere.accountbook.dto.MemberSignUpDto;
import com.payhere.accountbook.enntity.Member;

/**
 * @author jhkim
 * @since 2022-10-28
 *
 */
public interface MemberService {
	Member signUp(MemberSignUpDto memberSignUpDto);
	boolean isExistMember(MemberSignUpDto memberSignUpDto);
}
