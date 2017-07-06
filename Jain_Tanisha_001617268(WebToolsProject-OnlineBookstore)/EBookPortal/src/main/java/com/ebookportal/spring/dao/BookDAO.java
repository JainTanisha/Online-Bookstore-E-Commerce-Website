package com.ebookportal.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Book;

public class BookDAO extends DAO {

	
    public Book create(String isbn, String title, String author, String genre_name, long genreID, float price, String description, String photoName)
            throws EbookstoreException {
        try {
            begin();
            Book book = new Book(isbn, title, author, genre_name, genreID, price, description, photoName);
            getSession().save(book);
            commit();
            return book;
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Exception while creating book: " + e.getMessage());
        }
    }

    public void delete(Book book)
            throws EbookstoreException {
        try {
            begin();
            getSession().delete(book);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not delete book", e);
        }
    }
    
    public List list() throws EbookstoreException {
        try {
            begin();
            Query q = getSession().createQuery("from Book");
          //  q.setCacheable(true);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not list the books", e);
        }
    }
    
    
    public List<Book> searchBook(String key, String flag) throws EbookstoreException {
        try {
            begin();
           
            Query qry = getSession().createQuery("From Book b where b."+flag+"= :value");
           // qry.setCacheable(true);
            qry.setParameter("value", key);
            List<Book> list = new ArrayList<Book>();
            list = qry.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not list the books", e);
        }
    }
    
    
    public List<Book> listBook() throws EbookstoreException {
        try {
            begin();
            Query q = getSession().createQuery("from Book");
            //q.setCacheable(true);
            List list = q.list();
            
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not list the books", e);
        }
    }
    
    
    public Book getBookById(long id) throws EbookstoreException{
        try {
            begin();
            Query q = getSession().createQuery("from Book where bookID= :id");
            q.setLong("id", id);
            Book book = (Book) q.uniqueResult();
           // getSession().save(book);
            commit();
            return book;
        } catch(HibernateException e){
			rollback();
			throw new EbookstoreException("Could not get book!", e);	
    	}
       
    }
    
   
}