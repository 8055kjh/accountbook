package com.payhere.accountbook.model;

import java.time.LocalDateTime;
import java.util.List;

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
 *
 */
@Getter
@Setter
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNum;
	private String memberEmail;
	private String memberPw;
	private LocalDateTime memberRegDate;

	@OneToMany
	@JoinColumn(name = "member")
	private List<MemberRole> roles;

}
