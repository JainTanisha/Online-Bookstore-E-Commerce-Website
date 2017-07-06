package com.ebookportal.spring.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebookportal.spring.dao.OrderDetailsDAO;
import com.ebookportal.spring.pojo.OrderDetails;
import com.ebookportal.spring.pojo.Orders;

@Controller
@RequestMapping("/orderhistory.htm")
public class ListCustomerOrders {
	
	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView doSubmitAction(HttpServletRequest request) throws Exception
    {
		//HttpSession session = request.getSession();
		//long userId = (Long) session.getAttribute("userId");
		//System.out.println(userId);
		
		    OrderDetailsDAO orderDetails = new OrderDetailsDAO();
	        //long custid = 0;
			List odList = orderDetails.listOrders();
	        
	        System.out.print("the od list says that :::: "+ odList);
	        
	        ModelAndView mv = new ModelAndView("orderHistory","od", odList);
	        
	        //pageContext.setAttribute("odList", odList);
		return mv;	
	}
}
