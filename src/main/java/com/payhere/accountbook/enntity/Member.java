package com.payhere.accountbook.enntity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022/10/27
 * 회원 entity
 */
@Getter
@Setter
@Entity
public class Member extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNo;

	private String memberEmail;//회원 이메일

	private String memberPassword;//회원 비밀번호

	private String memberName;//회원이름

	private LocalDateTime memberSignupDate;

}
