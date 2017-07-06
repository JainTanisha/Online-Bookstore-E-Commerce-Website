package com.ebookportal.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebookportal.spring.dao.BookDAO;
import com.ebookportal.spring.dao.GenreDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Book;
import com.ebookportal.spring.pojo.Genre;

import net.sf.ehcache.CacheManager;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@Controller
//@RequestMapping("/listbooks.htm")
public class ListBookController{

//List of books shown to customer for purchase	
	@RequestMapping(value="/listbooks.htm",method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GenreDAO genres = null;
        List genreList = null;
        List bookList = new ArrayList();

        try {
        	genres = new GenreDAO();
        	genreList = genres.list();

            Iterator genreIterator = genreList.iterator();

            while (genreIterator.hasNext())
            {
                Genre genre = (Genre) genreIterator.next();

                Iterator bookIterator = genre.getBooks().iterator();

                while (bookIterator.hasNext())
                {
                    Book book = (Book) bookIterator.next();
                    bookList.add(book);
                }
            }
		
          
        } catch (EbookstoreException e) {
            System.out.println(e.getMessage());
        }
        
        ModelAndView mv = new ModelAndView("displayBooks", "books", bookList);
        return mv;
    }
	
//List of books displayed to Admin for delete and update:	
	@RequestMapping(value="/booklist.htm",method=RequestMethod.GET)
    protected ModelAndView handleAdminRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GenreDAO genres = null;
        List genreList = null;
        List bookList = new ArrayList();

        try {
        	genres = new GenreDAO();
        	genreList = genres.list();

            Iterator genreIterator = genreList.iterator();

            while (genreIterator.hasNext())
            {
                Genre genre = (Genre) genreIterator.next();

                Iterator bookIterator = genre.getBooks().iterator();

                while (bookIterator.hasNext())
                {
                    Book book = (Book) bookIterator.next();
                    bookList.add(book);
                }
            }
		
		
            //DAO.close();
        } catch (EbookstoreException e) {
            System.out.println(e.getMessage());
        }
        
        ModelAndView mv = new ModelAndView("adminEdit", "books", bookList);
        return mv;
    }
	
	
	
	
}