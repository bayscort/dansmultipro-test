package com.dansmultipro.dansmultiproservice.exeption;

import com.dansmultipro.dansmultiproservice.constant.enums.MessageResourceEnum;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BadRequestException extends RuntimeException {
	private MessageResourceEnum messageResourceEnum;
	private HttpStatus httpStatus;
	private String code;
	private String property;
	private String errorMessage;
	private List<String> validationMessages;
	private boolean isLogErrorMessage = true;

	public BadRequestException(MessageResourceEnum messageResourceEnum) {
		super(messageResourceEnum.getProperty());
		this.messageResourceEnum = messageResourceEnum;
		this.httpStatus = messageResourceEnum.getHttpStatus();
		this.code = messageResourceEnum.getCode();
		this.property = messageResourceEnum.getProperty();
	}

	public BadRequestException(MessageResourceEnum messageResourceEnum, List<String> validationMessages) {
		super(messageResourceEnum.getCode() + " - " + messageResourceEnum.getProperty());
		this.messageResourceEnum = messageResourceEnum;
		this.httpStatus = messageResourceEnum.getHttpStatus();
		this.code = messageResourceEnum.getCode();
		this.property = messageResourceEnum.getProperty();
		this.validationMessages = validationMessages;
	}

	public BadRequestException(MessageResourceEnum messageResourceEnum, boolean isLogErrorMessage) {
		super(messageResourceEnum.getCode() + " - " + messageResourceEnum.getProperty());
		this.messageResourceEnum = messageResourceEnum;
		this.httpStatus = messageResourceEnum.getHttpStatus();
		this.code = messageResourceEnum.getCode();
		this.property = messageResourceEnum.getProperty();
		this.isLogErrorMessage = isLogErrorMessage;
	}

	public BadRequestException(MessageResourceEnum messageResourceEnum, String errorMessage) {
		super(messageResourceEnum.getCode() + " - " + messageResourceEnum.getProperty() + " - " + errorMessage);
		this.messageResourceEnum = messageResourceEnum;
		this.httpStatus = messageResourceEnum.getHttpStatus();
		this.code = messageResourceEnum.getCode();
		this.property = messageResourceEnum.getProperty();
		this.errorMessage = errorMessage;
	}

	public BadRequestException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public BadRequestException(String message, boolean isLogErrorMessage) {
		super(message);
		this.errorMessage = message;
		this.isLogErrorMessage = isLogErrorMessage;
	}

	public MessageResourceEnum getMessageResourceEnum() {
		return messageResourceEnum;
	}

	public void setMessageResourceEnum(MessageResourceEnum messageResourceEnum) {
		this.messageResourceEnum = messageResourceEnum;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setLogErrorMessage(boolean logErrorMessage) {
		isLogErrorMessage = logErrorMessage;
	}

	public String getCode() {
		return code;
	}

	public String getProperty() {
		return property;
	}

	public boolean isLogErrorMessage() {
		return isLogErrorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public List<String> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(List<String> validationMessages) {
		this.validationMessages = validationMessages;
	}
}
