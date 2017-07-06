package com.ebookportal.spring.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ebookportal.spring.pojo.Admin;


public class AdminValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Admin.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	//User user = (User) obj;
    	Admin admin = (Admin) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "Username Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleName", "error.invalid.roleName", "RoleName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.invalid.emailID", "EmailID Required");
        
   
        }

	
	
	
}
