package com.ebookportal.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookportal.spring.dao.GenreDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Genre;

import net.sf.ehcache.CacheManager;

@Controller
//@RequestMapping("/addgenre.htm")
public class AddGenreFormController
{
	@Autowired
	@Qualifier("genreValidator")
	GenreValidator genreValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(genreValidator);
	}
	
	@RequestMapping(value="/addgenre.htm",method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("genre")Genre genre,BindingResult result) throws Exception
    {
		
		genreValidator.validate(genre, result);
		if(result.hasErrors())
		{
			return "addGenreForm";
		}
        
        try
        {
            GenreDAO genreDao = new GenreDAO();
       
            
            genreDao.create(genre.getGenreName());
           
        }
        catch (EbookstoreException e)
        {
            System.out.println(e.getMessage());
        }
        return "addedGenre";
    }
    
	@RequestMapping(value="/addgenre.htm",method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("genre")Genre genre, BindingResult result) { 
   
        return "addGenreForm"; 
    } 
}
