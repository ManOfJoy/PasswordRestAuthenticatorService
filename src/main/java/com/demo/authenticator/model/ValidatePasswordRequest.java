package com.demo.authenticator.model;

import org.springframework.stereotype.Component;

import com.demo.authenticator.validators.Authenticator;

/**
 * Model used in the Rest Service for posting user login authentication request
 * 
 * Using {@code @Authenticator} annotation to validate password
 * 
 * @author Manoj 09/14/2018
 *
 */
@Component
public class ValidatePasswordRequest {

	protected String userName;
	
	@Authenticator (message = "Password is Invalid")
	protected String password;
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "ValidatePasswordRequest [userName=" + userName + ", password=" + password + "]";
	}	
		
}
