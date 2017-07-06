package com.ebookportal.spring.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;

import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Book;
import com.ebookportal.spring.pojo.Customer;
import com.ebookportal.spring.pojo.Orders;

public class OrdersDAO extends DAO {

	
	public Orders create(Orders orders) throws EbookstoreException {
		try{
			begin();
			//Orders orders = new Orders(customerId);	
			getSession().save(orders);
			commit();
			return null;
		}
		catch(HibernateException e){
			rollback();
			throw new EbookstoreException("Orders table cannot be created", e);
		}
		
	}
	
//	   public List list() throws EbookstoreException {
//	        try {
//	            begin();
//	            Query q = getSession().createQuery("from Orders");
//	            List list = q.list();
//	            commit();
//	            return list;
//	        } catch (HibernateException e) {
//	            rollback();
//	            throw new EbookstoreException("Could not list the order items", e);
//	        }
//	    }
		
//	public void checkout(long userId, ArrayList<Book> cart){
//		//try{
//			//long orderId = 0;
//			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		    Date date = new Date();
//		    String orderDate = dateFormat.format(date);
//			begin();
//			//Customer customerId;
//			//Orders orders = new Orders(customerId);	
//			
//			//getSession().save(userId);
//			//getSession().save(orderDate);
//			commit();
//			
//			//getSession().save(cart);
//			
////			for (Book b: cart){
////				begin();
////				orderdetails details = new orderdetails();
////				orderdetails.set(b.getAuthor());
////				
////				save(ordertails);
//				//getSession().save(b);
//				
//				
//			//}
//		    
//		}
	}
	
    
    
    
    
    
	
	
	

