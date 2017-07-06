package com.ebookportal.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ebookportal.spring.exception.EbookstoreException;
import com.ebookportal.spring.pojo.User;

@Repository
public class UserDAO extends DAO {

	
	public User verifyUser(String username, String password, String roleName) throws EbookstoreException
	{
	try{
			begin();
			Query q = getSession().createQuery("from User where username= :username AND password= :password");
			// AND roleName= :roleName
			q.setString("username", username);
			q.setString("password", password);
			//q.setString("roleName",roleName);
			
			User user = (User)q.uniqueResult();
			commit();
			return user;
			

			
		}
		catch(HibernateException e){
			rollback();
			throw new EbookstoreException("Username and password are invalid!", e);
		}
	}
}
