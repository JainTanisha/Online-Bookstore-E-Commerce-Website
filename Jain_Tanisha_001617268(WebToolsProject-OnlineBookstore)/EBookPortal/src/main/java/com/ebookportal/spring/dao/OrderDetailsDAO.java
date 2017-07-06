package com.ebookportal.spring.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.OrderDetails;


public class OrderDetailsDAO extends DAO {

	
	public OrderDetails create(OrderDetails orderDetails) throws EbookstoreException {
		try{
			begin();	
			getSession().save(orderDetails);
			commit();
			return null;
		}
		catch(HibernateException e){
			rollback();
			throw new EbookstoreException("Order Details table cannot be created", e);
		}
		
	}
	//List for pdfview:::
	
	  public List listDetails(long userId) throws EbookstoreException {
	        try {
	            begin();
	           // long userid = (Long)session.getAttribute("userId");
	            Query q = getSession().createQuery("from OrderDetails where customerid= :userId");
	            q.setLong("userId", userId);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new EbookstoreException("Could not list the genres", e);
	        }
	    }
	
	  
	  public List listOrders() throws EbookstoreException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from OrderDetails");
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new EbookstoreException("Could not list the order details! Try again.", e);
	        }
	    }

}
