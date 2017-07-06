package com.ebookportal.spring.dao;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Customer;
import com.ebookportal.spring.pojo.User;

public class CustomerDAO extends DAO {

	public CustomerDAO(){	
	}
	
	public Customer get(String username)
		throws EbookstoreException{
		try{
			begin();
			Query q = getSession().createQuery("from Customer where username= :username");
			q.setString("username", username);
			Customer customer = (Customer) q.uniqueResult();
			commit();
			return customer;
		}
		catch(HibernateException e){
			rollback();
			throw new EbookstoreException("No such user named"+username+"exists!",e );
		}
	}
	
//	HttpServletRequest request;
//	HttpSession session = request.getSession();
	
	
	
	 public List<User> listUsername() throws EbookstoreException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User");
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new EbookstoreException("Could not list the users", e);
	        }
	    }
	
	 
	   public List listCustomers() throws EbookstoreException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Customer");
	           // q.setCacheable(true);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new EbookstoreException("Could not list the customers! Try again.", e);
	        }
	    }
	 
	 
	  public Customer create(String firstName, String lastName,String emailID, String roleName, 
			  String username, String password, String address, String city, String zip, String state,
			  String country, String phone,String gender)
	            throws EbookstoreException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	           
	            Customer customer=new Customer(address, city, zip, state, country, phone, gender);
	            //this is matching with the constructor in the customer pojo
	            
	            customer.setFirstName(firstName);
	            customer.setLastName(lastName);
	            customer.setEmailID(emailID);
	            customer.setRoleName(roleName);
	            customer.setUsername(username);
	            customer.setPassword(password);
	          
	            getSession().save(customer);
	            
	            commit();
	            return customer;
	            
	        } catch (HibernateException e) {
	            rollback();
	            throw new EbookstoreException("Exception while creating customer: " + e.getMessage());
	        }
	    }
	  
	  public void delete(Customer customer)
	            throws EbookstoreException {
	        try {
	            begin();
	            getSession().delete(customer);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new EbookstoreException("Could not delete customer " + customer.getFirstName(), e);
	        }
	    }
	
	
	
}
