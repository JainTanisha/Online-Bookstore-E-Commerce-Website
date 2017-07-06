package com.ebookportal.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ebookportal.spring.dao.BookDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Book;

@Controller
public class EditBookController {

	@RequestMapping(value="/deleteBook.htm",method=RequestMethod.GET)
	protected String doDeleteAction(@RequestParam("id") long id, HttpServletRequest request) throws EbookstoreException {
		
		BookDAO bookDao = new BookDAO();
		Book book = bookDao.getBookById(id);
		bookDao.delete(book);
		
		return "deletedBook";
	
	
	}
	
	
	
	

	@RequestMapping(value="/manageBooks.htm", method=RequestMethod.GET)
	protected String manageBooksAction(HttpServletRequest request){
		return "manageBooks";
	}
	
	
	
	
}
