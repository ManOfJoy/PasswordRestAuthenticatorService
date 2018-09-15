package com.demo.authenticator.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.demo.authenticator.config.YAMLConfig;

/**
 * Implements ConstraintValidator
 * Use isValid method to check validation for password String
 * 
 * @author Manoj 09/14/2018
 * 
 */
@Component
public class PasswordAuthenticator implements ConstraintValidator<Authenticator, String> {

	@Autowired
	YAMLConfig yamlConfig;

	public void initialize(Authenticator annotation) {}
	
	/* Matches password String against password rules and returns true/false
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		
		boolean result=true;
		if(StringUtils.isEmpty(password)){
			result = false;
		}
		else{
			// Match to the password rules and return true/false
			HashMap<String, String> positiveRules = yamlConfig.getPasswordPostiveRules();
			HashMap<String, String> negativeRules = yamlConfig.getPasswordNegativeRules();
			Pattern pattern;
			Matcher matcher;
			for (Map.Entry<String, String> entry : positiveRules.entrySet()) {
				pattern = Pattern.compile(entry.getValue());
				matcher = pattern.matcher(password);
				if(!matcher.matches()){
					result = false;
					break;
			    }
			}
			/* Call negate rules only if positive rules are success */
			if(result){
				for (Map.Entry<String, String> rulesEntry : negativeRules.entrySet()) {
					pattern = Pattern.compile(rulesEntry.getValue());
					matcher = pattern.matcher(password);
					if(matcher.find()){
						result = false;
						break;
				    }
				}
			}
		}
		
		return result;
	}
}
