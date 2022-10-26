package com.payhere.accountbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jhkim
 * @since 2022/10/27
 *
 */
@Getter
@Setter
@Entity
public class MemberRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberRoleNum;
	private String roleName;
}
