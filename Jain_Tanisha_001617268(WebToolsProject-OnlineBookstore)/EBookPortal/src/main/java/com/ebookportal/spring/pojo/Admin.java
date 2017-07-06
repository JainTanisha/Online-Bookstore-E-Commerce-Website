package com.ebookportal.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="admin_table")
@PrimaryKeyJoinColumn(name="userID")
//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Admin extends User {
	
	@Column(name="adminAge")
	private int adminAge;
	
	public Admin(int adminAge){
		this.adminAge=adminAge;
	}
	
    Admin(){
		
	}
	
	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}
	
}

