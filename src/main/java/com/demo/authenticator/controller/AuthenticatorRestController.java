package com.demo.authenticator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.authenticator.config.YAMLConfig;
import com.demo.authenticator.model.ValidatePasswordRequest;
import com.demo.authenticator.model.ValidatePasswordResponse;

/**
 * Rest Service to validate Password
 * 
 * @author Manoj 09/12/2018
 * 
 */
@RestController
public class AuthenticatorRestController {

	@Autowired
	YAMLConfig yamlConfig;
	
	@RequestMapping(value = "/validatePassword", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public
    @ResponseBody
    ValidatePasswordResponse validatePassword(
            @Valid @RequestBody ValidatePasswordRequest validatePwdRequest, Errors errors) {
		ValidatePasswordResponse validateResponse = new ValidatePasswordResponse();
		
		if(errors.hasErrors()){
			validateResponse.setCode(errors.getAllErrors().get(0).getCode());
			validateResponse.setMessage(errors.getAllErrors().get(0).getDefaultMessage());
		}
		else{
			validateResponse.setCode("SUCCESS");
			validateResponse.setMessage("Authentication SuccessFul");		
		}
    	return validateResponse;   
    }
   
}
