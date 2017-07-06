package com.ebookportal.spring.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebookportal.spring.dao.OrderDetailsDAO;
import com.ebookportal.spring.dao.OrdersDAO;
import com.ebookportal.spring.pojo.Book;
import com.ebookportal.spring.pojo.OrderDetails;
import com.ebookportal.spring.pojo.Orders;

@Controller
//@RequestMapping()
public class CheckoutController {
	
	@RequestMapping(value="/placeorder.htm",method=RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("orders")Orders orders, HttpServletRequest request) throws Exception
    {
		HttpSession session = request.getSession();
		
		long userId = (Long) session.getAttribute("userId");
        ArrayList<Book> cart = (ArrayList<Book>)session.getAttribute("cart");
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    String orderDate = dateFormat.format(date);
        
	    int count=0;
	    for(Book b:cart){
	    	count++;
	    }
	    
        OrdersDAO ordersDao = new OrdersDAO();
        orders.setOrderDate(orderDate);
        orders.setCustomerId(userId);
        orders.setItemNumber(count);
        ordersDao.create(orders);
        
        
        for(Book b: cart){
        	OrderDetails od = new OrderDetails();
        	OrderDetailsDAO odDao = new OrderDetailsDAO();
        	
        	od.setBookId(b.getBookID());
        	od.setPrice(b.getPrice());
        	od.setBookName(b.getTitle());
        	od.setBookAuthor(b.getAuthor());
        	od.setDate(orders.getOrderDate());
        	od.setOrderId(orders.getOrderID());
        	od.setCustomerId(orders.getCustomerId());
        	odDao.create(od);
        }
        
        session.removeAttribute("cart");
        session.setAttribute("orderId", orders.getOrderID());
        
        ModelAndView mv = new ModelAndView("orderedItems");
		return mv;
    }
}	


