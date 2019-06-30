package com.docplexus.common.enums;

public enum StatusEnum {
	ACTIVE("A"), PROCESSING("P"), ONHOLD("H"), CLOSE("C"), ;

	private final String status;

	private StatusEnum(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}

}