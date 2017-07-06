package com.ebookportal.spring.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Genre;

public class GenreDAO extends DAO {

    public Genre get(String genreName) throws EbookstoreException {
        try {
            begin();
            Query q=getSession().createQuery("from Genre where genreName= :genreName");
            q.setString("genreName", genreName);
           // q.setCacheable(true);
            Genre genre=(Genre)q.uniqueResult();
            commit();
            return genre;
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not obtain the named genre " + genreName + " " + e.getMessage());
        }
    }

    public List list() throws EbookstoreException {
        try {
            begin();
            Query q = getSession().createQuery("from Genre");
            List list = q.list();
          //  q.setCacheable(true);
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not list the genres", e);
        }
    }
    
    
    public List<Genre> listGenre() throws EbookstoreException {
        try {
            begin();
            Query q = getSession().createQuery("from Genre");
            List list = q.list();
           // q.setCacheable(true);
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not list the genres", e);
        }
    }
    
    

    public Genre create(String genreName) throws EbookstoreException {
        try {
            begin();
            Genre genre = new Genre(genreName);
            getSession().save(genre);
            commit();
            return null;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new EbookstoreException("Exception while creating genre: " + e.getMessage());
        }
    }

    public void save(Genre genre) throws EbookstoreException {
        try {
            begin();
            getSession().update(genre);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not save the genre", e);
        }
    }

    public void delete(Genre genre) throws EbookstoreException {
        try {
            begin();
            getSession().delete(genre);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EbookstoreException("Could not delete the genre", e);
        }
    }
}