package com.ebookportal.spring.controllers;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ebookportal.spring.dao.GenreDAO;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Genre;
import com.ebookportal.spring.pojo.User;

import org.springframework.validation.ValidationUtils;

@Component
public class GenreValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Genre.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Genre genre = (Genre) obj;

    	GenreDAO genreDao = new GenreDAO();
		List<Genre> gen;
		try {
			gen = genreDao.listGenre();
			for (Genre g : gen){
				if(g.getGenreName().equalsIgnoreCase(genre.getGenreName())){
					
					 errors.rejectValue("genreName", "genreName.alreadyExist",
			                    "This Genre already exists!");
				}
			}
			
			
		} catch (EbookstoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genreName", "error.invalid.genreName", "Genre Required");
    }
}
