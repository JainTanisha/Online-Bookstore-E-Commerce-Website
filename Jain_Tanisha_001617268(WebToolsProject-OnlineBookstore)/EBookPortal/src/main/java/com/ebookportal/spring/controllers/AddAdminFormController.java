package com.ebookportal.spring.controllers;

	import javax.servlet.http.HttpServletRequest;

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
	import com.ebookportal.spring.exception.EbookstoreException;
	import com.ebookportal.spring.pojo.Admin;

	@Controller
//	@RequestMapping("/addadmin.htm")
	public class AddAdminFormController {
		
		@Autowired
		@Qualifier("adminValidator")
		AdminValidator validator;

		@InitBinder
		private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
		}

		@RequestMapping(value="/addadmin.htm",method = RequestMethod.POST)
		protected String doSubmitAction(@ModelAttribute("admin") Admin admin, BindingResult result) throws Exception {
			validator.validate(admin, result);
			if (result.hasErrors()) {
				return "addAdminForm";
			}

			try {
				System.out.print("test");
				
				AdminDAO adminDao = new AdminDAO();
				System.out.print("test1");
				
				adminDao.create(admin.getFirstName(), admin.getLastName(), admin.getEmailID(), 
						admin.getRoleName(), admin.getUsername(), admin.getPassword(), admin.getAdminAge());
				
				DAO.close();
			} catch (EbookstoreException e) {
				System.out.println("Exception: " + e.getMessage());
			}

			return "addedCustomer";
		}

		@RequestMapping(value="/addadmin.htm", method = RequestMethod.GET)
		public String initializeForm(@ModelAttribute("admin") Admin admin, BindingResult result) {

			return "addAdminForm";
		}
		
		@RequestMapping(value="/viewCustomers.htm",method = RequestMethod.GET)
		protected String doViewCustomerAction(HttpServletRequest request){
			return "viewCustomers";
			
		}
		
		
		@RequestMapping(value="/viewAllOrders.htm",method = RequestMethod.GET)
		protected String doViewOrderAction(HttpServletRequest request){
			return "viewAllOrders";
			
		}
	
		
	}
