package com.ebookportal.spring.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ebookportal.spring.pojo.User;


public class UserValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	//User user = (User) obj;
    	User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "Username Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");    
    }

}
