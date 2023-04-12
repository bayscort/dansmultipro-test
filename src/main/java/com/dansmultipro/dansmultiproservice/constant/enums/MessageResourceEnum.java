package com.dansmultipro.dansmultiproservice.constant.enums;

import org.springframework.http.HttpStatus;

public enum MessageResourceEnum {
	SUCCESS("00"),
	SUCCESS_WITH_MESSAGE("01"),
	FAILED("02"),
	FAILED_WITH_MESSAGE("03"),
	SESSION_INVALID("03", "session.invalid"),
	GENDER_VALUE(HttpStatus.BAD_REQUEST, "03", "system.gender.value");

	private HttpStatus httpStatus;
	private String code;
	private String property;

	MessageResourceEnum(String code) {
		this.code = code;
	}

	MessageResourceEnum(String code, String property) {
		this.code = code;
		this.property = property;
	}

	MessageResourceEnum(HttpStatus httpStatus, String code, String property) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.property = property;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
