# PasswordRestAuthenticatorService

## RESTFul Service for Password authentication

Password Validation RestFul Service with Spring IOC.
The service is meant to check a text string for compliance to any number of password validation rules. 
The rules currently known are:

- Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
- Must be between 5 and 12 characters in length.
- Must not contain any sequence of characters immediately followed by the same sequence.

## Build Information

This is a spring boot application,   import the application into ecliple or IntelliJ with maven import.

Two ways to start/run the application:-

1. Run the application as a Spring Boot Application in Eclipse and it starts the application on port 8085 as configured.

```
RightClick on the Project->Browse to DemoApplication.java->Run As->Java Application
```

2. Command Line or Terminal execute below command to bootstrap and start the application.

```
$ mvn spring-boot:run
```

## Password Validation using Annotation
Added @Authenticator annotation to a field in request object ValidatePasswordRequest. 
This annotation only works on fields as designed.

```
@Password
private String password;
```

If Password is invalid message will be returned.
```
@Authenticator (message = "Password is Invalid")
protected String password;
```

## Test the Application in two ways
1. Calling the RestFul Service via localhost
```
http://localhost:8085/authenticator/validatePassword
```
POST the request as below:
```
	{
		"userName": "manoj",
		"password": "111manojj"
	}
```
Result will be:
```
{
    "code": "Authenticator",
    "message": "Password is Invalid"
}
```

2. Running the Junit Test DemoApplicationTests to validate passwords
```
Will show results of 21 tests including both valid and invalid combinations
```

## Manage password rules
Rules are categorized as positive and negative.  Rules with 'Must' are in passwordPositiveRules and 'Must not' are in passwordNegativeRules.  Any future rules can be added in application.yml accordingly.

```
application.yml
passwordPostiveRules:
    #Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each
      - rule1: "^([0-9]+[a-z]+|[a-z]+[0-9]+)[0-9a-z]*$" 
    #Must be between 5 and 12 characters in length
      - rule2: "^(.{5,12}$)"
passwordNegativeRules:
    #Must not contain any sequence of characters immediately followed by the same sequence
      - rule1: "(\\S+?)\\1"
```
