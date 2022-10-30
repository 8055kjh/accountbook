package com.payhere.accountbook.domain.enntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jhkim
 * @since 2022/10/28
 *
 */
public enum TransactionType {
	@JsonProperty("수입")
	INCOME,
	@JsonProperty("지출")
	EXPENSE;
/*
	private final String value;

	public String getValue() {
		return value;
	}

	TransactionType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static TransactionType JsonConvert (String value) {
		for(TransactionType type : TransactionType.values()) {
			if(type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}*/
}
