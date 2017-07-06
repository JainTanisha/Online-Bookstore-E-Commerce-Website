package com.ebookportal.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookportal.spring.dao.AdminDAO;
import com.ebookportal.spring.dao.DAO;
import com.ebookportal.spring.dao.UserDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Admin;
import com.ebookportal.spring.pojo.User;

@Controller
//@RequestMapping("/checkuser.htm")

public class LoginFormController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

//	@ModelAttribute("user")
//    public User getUser(HttpServletRequest request) 
//    {
//        return (User) request.getAttribute("user");
//    }
	
	HttpSession session;
	
	@RequestMapping(method = RequestMethod.POST, value="/login.htm")
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "LoginForm";
		}
		
		session = request.getSession();

		try {
			System.out.print("test");
			User user1 = userDao.verifyUser(user.getUsername(), user.getPassword(), user.getRoleName());
			
			if(user1!=null){
				if(user1.getRoleName().equals("admin")){
					session.setAttribute("username", user1.getUsername());
					session.setAttribute("role", "admin");
					session.setAttribute("userId", user1.getUserID());
					//return "top_nav";
					return "adminSuccess";
				}
				else if (user1.getRoleName().equals("Customer")){
					session.setAttribute("username", user1.getUsername());
					session.setAttribute("role", "Customer");
					session.setAttribute("userId", user1.getUserID());
					System.out.println(user1.getUserID());
					//return "customerSuccess";
					return "customerSuccess";
				}
				else{
					System.out.println("Login has failed.");
				    return "errorLogin";
				}
			}
			else{
				System.out.println("User not Found.");
			    return "errorLogin";
			}
			
		} catch (EbookstoreException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "LoginForm";
	}

	@RequestMapping(method= RequestMethod.GET, value="/logout.htm")
	public String doLogoutAction(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) throws Exception {
		//HttpSession session = request.getSession();
		request.getSession().invalidate();
		return "logout";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {
		//request.getSession().setAttribute("username", user.getUsername());
		System.out.println("hello");
		return "LoginForm";
	}
}
