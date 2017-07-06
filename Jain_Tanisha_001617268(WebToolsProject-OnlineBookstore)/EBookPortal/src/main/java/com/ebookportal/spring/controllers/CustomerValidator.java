package com.ebookportal.spring.controllers;


import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.ebookportal.spring.dao.CustomerDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Customer;
import com.ebookportal.spring.pojo.User;

public class CustomerValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Customer.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	//User user = (User) obj;
    	Customer customer = (Customer) obj;
    	
    	CustomerDAO customerDao = new CustomerDAO();
		List<User> user;
		try {
			user = customerDao.listUsername();
			for (User u : user){
				if(u.getUsername().equals(customer.getUsername())){
					
					 errors.rejectValue("username", "username.alreadyExist",
			                    "Username already exist");
				}
			}
			
			
		} catch (EbookstoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.invalid.emailID", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress", "error.invalid.customerAddress", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerCity", "error.invalid.customerCity", "City Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerZip", "error.invalid.customerZip", "Zip Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerState", "error.invalid.customerState", "State Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerCountry", "error.invalid.customerCountry", "Country Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerPhone", "error.invalid.customerPhone", "Phone Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.customer", "Gender Required");
        
        }
}
