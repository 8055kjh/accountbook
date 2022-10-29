package com.payhere.accountbook.service.impl;

import org.springframework.stereotype.Service;

import com.payhere.accountbook.domain.dto.AuthenticationRequestDto;
import com.payhere.accountbook.domain.dto.AuthenticationResponseDto;
import com.payhere.accountbook.domain.enntity.Member;
import com.payhere.accountbook.exception.NotExistMemberException;
import com.payhere.accountbook.repository.MemberRepository;
import com.payhere.accountbook.security.JwtTokenProvider;
import com.payhere.accountbook.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto) {
        Member member = memberRepository.findByMemberEmail(authenticationRequestDto.getEmail());
        if(member == null) {
            throw new NotExistMemberException();
        }
        return new AuthenticationResponseDto(jwtTokenProvider.createToken(member.getMemberEmail()));
    }

}
