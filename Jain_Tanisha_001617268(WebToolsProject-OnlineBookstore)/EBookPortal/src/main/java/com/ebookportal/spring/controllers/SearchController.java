package com.ebookportal.spring.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebookportal.spring.pojo.Book;
import com.ebookportal.spring.dao.BookDAO;

@Controller
//@RequestMapping("/search.htm")
public class SearchController {
	 
//	private BookDAO bookDao;
//	 
//public BookDAO getBookDao() {
//		return bookDao;
//	}
//
//	public void setBookDao(BookDAO bookDao) {
//		this.bookDao = bookDao;
//	}
	
	@RequestMapping(value="/search.htm", method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
    
	  String action = hsr.getParameter("action");
      //action is defined in the query.
      if (action.equalsIgnoreCase("search")) {
		
       List<Book> bookList = new ArrayList();
       String key = hsr.getParameter("key");
       String searchKey = hsr.getParameter("flag");
		
       BookDAO bookDao = new BookDAO();
      
       bookList = bookDao.searchBook(key, searchKey);
       
       System.out.println(bookList);
       
       JSONObject obj = new JSONObject();
       obj.put("books", bookList);
       PrintWriter out = hsr1.getWriter(); //response
       out.println(obj);
      }
      // ModelAndView mv = new ModelAndView("searchBook");
       return null; 
	}
	
	
	@RequestMapping(value="/searchBookPage.htm", method=RequestMethod.GET)
	public ModelAndView searchRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		ModelAndView mv = new ModelAndView("searchBook");
	       return mv; 
	}
}
