package com.example.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.authenticator.DemoApplication;
import com.demo.authenticator.config.YAMLConfig;
import com.demo.authenticator.validators.PasswordAuthenticator;

/**
 * Test Suite to run valid and invalid password scenarios
 * 
 * 	@author Manoj 09/14/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {YAMLConfig.class, DemoApplication.class})
@AutoConfigureMockMvc
public class DemoApplicationTests {
		
		@Autowired
		PasswordAuthenticator passwordValidator;
		
		private ConstraintValidatorContext constraintValidatorContext;
		
		@Before
		public void setUp() throws Exception {			
				
		}
	 
		//Scenarios for reference
	    /*Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each
	    Must be between 5 and 12 characters in length
	    Must not contain any sequence of characters immediately followed by the same sequence
	    */  
		/**
		 * Test scenarios for password validation covering Invalid.
		 */
		@Test
		public void nullPasswordTest() {
			String password = null;
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void emptyPasswordTest() {
			String password = "";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void mixtureOfLowerCaseAndNumberLengthLessThan5Test() {
			String password = "p1p2";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void mixtureOfLowerCaseAndNumberLengthGreaterThan12Test() {
			String password = "p1p2p3p4p5p6p";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void upperCaseTest() {
			String password = "p1P345";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void noNumberTest() {
			String password = "aplhabets";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void noAlphabetTest() {
			String password = "12345";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void withSameSequenceofCharactersTest() {
			String password = "1maaanoj";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
	
		
		@Test
		public void withSameSequenceOfNumbersTest() {
			String password = "111manoj";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void withSameSequenceStringTest() {
			String password = "manman1";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void withSameSequenceStringMultiTest() {
			String password = "ma1mamama1";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void withSameSequenceStringAndNumberMultiTest() {
			String password = "mama111mama111";
			assertFalse( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void withAlphabetNumberAndAlphaNumbericTest() {	
			String password = "mana123@";
			assertFalse(this.passwordValidator.isValid( password, this.constraintValidatorContext ));
		}
		
		@Test
		public void withAlphabetNumberAndAlphaNumbericMultiTest() {	
			String password = "mana#123@";
			assertFalse(this.passwordValidator.isValid( password, this.constraintValidatorContext ));
		}
		
		/**
		 * Test scenarios for password validation covering Valid.
		 */
		@Test
		public void validDigitsAndAlphabetsTest() {
			String password = "1234a";
			assertTrue( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}

		@Test
		public void validDigitsAndAlphabetsLength12Test() {
			String password = "123456789man";
			assertTrue( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void validDigitsAndAlphabetsRandomSameLetterTest() {
			String password = "m2m4m6m7m8";
			assertTrue( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void validDigitsAndAlphabetsSameDigitRandomTest() {
			String password = "m2a2n2o2j2";
			assertTrue( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void validDigitsAndAlphabetsRandomTest() {
			String password = "ma23no34j";
			assertTrue( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
		
		@Test
		public void validRandomSequenceofCharactersTest() {
			String password = "man2man5man7";
			assertTrue( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
			
		@Test
		public void validRandomSequenceofDigitsTest() {
			String password = "123manoj123";
			assertTrue( this.passwordValidator.isValid( password, this.constraintValidatorContext ) );
		}
}
