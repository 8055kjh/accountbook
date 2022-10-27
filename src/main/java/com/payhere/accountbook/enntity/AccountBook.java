package com.payhere.accountbook.enntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022/10/28
 * 가계부 entity
 */
@Getter
@Setter
@Entity
public class AccountBook extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountBookNo;

	private String accountBookName;

	private Character deleteYn;

	private String memo;
}
