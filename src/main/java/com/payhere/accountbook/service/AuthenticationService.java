package com.payhere.accountbook.service;

import com.payhere.accountbook.domain.dto.AuthenticationRequestDto;
import com.payhere.accountbook.domain.dto.AuthenticationResponseDto;

/**
 * @author jhkim
 * @since 2022-10-29
 *
 */
public interface AuthenticationService {
	AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto);

}
