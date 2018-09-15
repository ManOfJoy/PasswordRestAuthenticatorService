package com.demo.authenticator.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * Annotation using PasswordAuthenticator validator implementation
 * 
 * @author Manoj 09/14/2018
 *
 */

@Constraint(validatedBy = { PasswordAuthenticator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authenticator {

	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload()default{};
}
