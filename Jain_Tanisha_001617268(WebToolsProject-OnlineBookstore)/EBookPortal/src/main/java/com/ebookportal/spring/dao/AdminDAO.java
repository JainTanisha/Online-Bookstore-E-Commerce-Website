package com.ebookportal.spring.dao;

import org.hibernate.HibernateException;
import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.Admin;

public class AdminDAO extends DAO {

	public AdminDAO(){	
	}
	
	  public Admin create(String firstName, String lastName,String emailID, String roleName, 
			  String username, String password, int adminAge )
	            throws EbookstoreException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	           
	             Admin admin = new Admin(adminAge);
	            
	            admin.setFirstName(firstName);
	            admin.setLastName(lastName);
	            admin.setEmailID(emailID);
	            admin.setRoleName(roleName);
	            admin.setUsername(username);
	            admin.setPassword(password);
	            
	            
	            getSession().save(admin);
	            
	            commit();
	            return admin;
	            
	        } catch (HibernateException e) {
	        	rollback();
	            throw new EbookstoreException("Exception while creating admin: " + e.getMessage());
	        }
	    }
	  
	  public void delete(Admin admin)
	            throws EbookstoreException {
	        try {
	            begin();
	            getSession().delete(admin);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new EbookstoreException("Could not delete admin " + admin.getFirstName(), e);
	        }
	    }
	
	
	
}
