package com.ebookportal.spring.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ebookportal.spring.dao.BookDAO;
import com.ebookportal.spring.dao.GenreDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Book;
import com.ebookportal.spring.pojo.Genre;

@Controller
//@RequestMapping("/addbook.htm")
public class AddBookFormController extends SimpleFormController {

	@Autowired
	@Qualifier("bookValidator")
	BookValidator bookValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(bookValidator);
	}
	
	@RequestMapping(value="/addbook.htm",method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("book")Book book,BindingResult result) throws Exception{

		bookValidator.validate(book, result);
		
		if(result.hasErrors())
		{
			return "addBookForm";
		}
    	
        String genreTitle = book.getGenre_name();
        String title = book.getTitle();      

        try {
            
        	System.out.println("inside DAO");
        	
        	GenreDAO genres = new GenreDAO();
            BookDAO bookDao = new BookDAO();
            Genre genre = genres.get(genreTitle);
        	
        //File upload code starts:
            
            File file;
            String check = File.separator;
            String path = null;
            if(check.equalsIgnoreCase("\\")) {
            path = getServletContext().getRealPath("").replace("build\\","");
            //path = "/EBookPortal/src/main/webapp/resources";
         }
         
            if(check.equalsIgnoreCase("/")) {
            path = getServletContext().getRealPath("").replace("build/","");
            path += "/";
            //path = "/EBookPortal/src/main/webapp/resources";
         }
            
            if(book.getPhoto()!=null){
                String fileNameWithExt = System.currentTimeMillis() + book.getPhoto().getOriginalFilename();
                file = new File(path + fileNameWithExt);
                String context = getServletContext().getContextPath();
            
                book.getPhoto().transferTo(file);
                
                book.setPhotoName(context + "/"+ fileNameWithExt);
             }
            
        //file upload code ends
            
                Book bk = bookDao.create(book.getIsbn(), title, book.getAuthor(), genre.getGenreName(), genre.getGenreID(), book.getPrice(), book.getDescription(), book.getPhotoName());
                genre.addBook(bk);
                genres.save(genre);
             
        } catch (EbookstoreException e) {
            System.out.println(e.getMessage());
        }
        return "addedBook";
     }   

    
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("book")Book book, BindingResult result) { 
        return "addBookForm"; 
    } 
}