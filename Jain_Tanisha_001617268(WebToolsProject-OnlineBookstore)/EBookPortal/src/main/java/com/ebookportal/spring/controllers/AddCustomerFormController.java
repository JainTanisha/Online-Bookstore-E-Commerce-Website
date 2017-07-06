package com.ebookportal.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookportal.spring.dao.CustomerDAO;
import com.ebookportal.spring.dao.DAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Customer;
import com.ebookportal.spring.pojo.User;

@Controller
@RequestMapping("/addcustomer.htm")
public class AddCustomerFormController {
	
	@Autowired
	@Qualifier("customerValidator")
	CustomerValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("customer") Customer customer, BindingResult result) throws Exception {
		validator.validate(customer, result);
		if (result.hasErrors()) {
			return "addCustomerForm";
		}

		try {
			System.out.print("test");
			
			//if(customer.getRoleName()=="Customer"){
			CustomerDAO customerDao = new CustomerDAO();
			//System.out.print("test1");
//			User user =new User();
//			List<User> user = customerDao.listUsername();
//			
//			for (User u : user){
//				if(u.getUsername().equals(customer.getUsername())){
//					
//					return "addCustomerForm";
//				}
//			}
			
//			for(int i=0; i<=userlist.size(); i++){
//				if(user.getUsername().equals(customer.getUsername())){
//					System.out.println("Please select a different username!");
//					return "addCustomerForm";
//				}
//				
//				else{
//						}
//				
//			}
			customerDao.create(customer.getFirstName(), customer.getLastName(), customer.getEmailID(), 
					customer.getRoleName(), customer.getUsername(), customer.getPassword(), customer.getCustomerAddress(),
					customer.getCustomerCity(), customer.getCustomerZip(), customer.getCustomerState(),
					customer.getCustomerCountry(), customer.getCustomerPhone(), customer.getCustomerGender());
	
//			}
//			
//			else{
//				System.out.println("it is a bookseller!");
//			}
			
			//DAO.close();
		} catch (EbookstoreException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "addedCustomer";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("customer") Customer customer, BindingResult result) {

		return "addCustomerForm";
	}
}