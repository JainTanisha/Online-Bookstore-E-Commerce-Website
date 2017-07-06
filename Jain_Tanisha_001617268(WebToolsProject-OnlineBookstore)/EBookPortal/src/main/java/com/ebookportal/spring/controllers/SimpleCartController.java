package com.ebookportal.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ebookportal.spring.dao.BookDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Book;

@Controller
public class SimpleCartController {

//	@Autowired
//	BookDAO bookDao;
	BookDAO bookDao=new BookDAO();
	
	@RequestMapping(value="/viewcart.htm",method=RequestMethod.GET)
	protected String doViewAction(HttpServletRequest request, HttpServletResponse response) 
			throws EbookstoreException {
		HttpSession session = request.getSession();
		ArrayList<Book> cart;
		if(session.getAttribute("cart")!=null){
			cart=(ArrayList<Book>)session.getAttribute("cart");
			return "displayCart";
		}
		else{
			return "displayCart";
		}
				
	}
	
	@RequestMapping(value="/addtocart.htm",method=RequestMethod.GET)
	protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response) 
			throws EbookstoreException {

		HttpSession session = request.getSession();
		
		ArrayList<Book> cart;
		if(session.getAttribute("cart")!=null){
			cart=(ArrayList<Book>)session.getAttribute("cart");
		}
		else{
			cart = new ArrayList<Book>(); 
		}
		long id=Long.parseLong(request.getParameter("id"));
		System.out.print(id);
		BookDAO bookDao=new BookDAO();
		Book book = bookDao.getBookById(id);
		cart.add(book);
		
		float total = 0;
		for(Book b : cart){
			total = total + b.getPrice();
		}
		session.setAttribute("cart", cart);
		session.setAttribute("total", total);
		ModelAndView mv = new ModelAndView("displayCart", "cart", cart);
		mv.addObject("total", total);
		//mv.setViewName("displayCart");
	    return mv;
		//return "addedToCart";
	}
	
	@RequestMapping(value="/removeitem.htm",method=RequestMethod.GET)
	protected ModelAndView doAction(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) 
			throws EbookstoreException {
		HttpSession session = request.getSession();
		ArrayList<Book> value;
		
		if(session.getAttribute("cart")!=null){
			value=(ArrayList<Book>)session.getAttribute("cart");
			System.out.println(id);		
			value.remove(id);
			
			float total = 0;
			for(Book b : value){
				total = total + b.getPrice();
			}
			session.setAttribute("total", total);
			ModelAndView mv = new ModelAndView("displayCart");
			return mv;
		}
		else{
			ModelAndView mv = new ModelAndView("displayCart");
			return mv;
		}
		
	
		
		
	
		
		
		
		
	}
	
	
	
	
}
