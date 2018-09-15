package com.demo.authenticator.model;

import org.springframework.stereotype.Component;

/**
 * Response to the Rest Service call for password authentication
 * 
 * @author Manoj 09/14/2018
 *
 */
@Component
public class ValidatePasswordResponse {
	
	protected String code;
	protected String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ValidatePasswordResponse [code=" + code + ", message=" + message + "]";
	}
}
