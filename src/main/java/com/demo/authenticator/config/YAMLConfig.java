
package com.demo.authenticator.config;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration pulled from application.yml 
 * 
 * @author Manoj
 *
 */

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
  
    private HashMap<String, String> passwordPostiveRules = new HashMap<String, String>();
    private HashMap<String, String> passwordNegativeRules = new HashMap<String, String>();
    
	public HashMap<String, String> getPasswordPostiveRules() {
		return passwordPostiveRules;
	}
	public void setPasswordPostiveRules(HashMap<String, String> passwordPostiveRules) {
		this.passwordPostiveRules = passwordPostiveRules;
	}
	public HashMap<String, String> getPasswordNegativeRules() {
		return passwordNegativeRules;
	}
	public void setPasswordNegativeRules(HashMap<String, String> passwordNegativeRules) {
		this.passwordNegativeRules = passwordNegativeRules;
	}
    	
}


