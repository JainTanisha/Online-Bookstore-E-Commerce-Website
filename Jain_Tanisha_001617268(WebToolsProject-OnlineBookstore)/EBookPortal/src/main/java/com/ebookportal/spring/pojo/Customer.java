package com.ebookportal.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")
@PrimaryKeyJoinColumn(name="userID")

public class Customer extends User {
	
	@Column(name="customerAddress")
	private String customerAddress;
	
	@Column(name="customerCity")
	private String customerCity;
	
	@Column(name="customerZip")
	private String customerZip;
	
	@Column(name="customerState")
	private String customerState;
	
	@Column(name="customerCountry")
	private String customerCountry;
	
	@Column(name="customerPhone")
	private String customerPhone;
	
	@Column(name="customerGender")
	private String customerGender;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="customerID")
//	private Set<Orders> orders = new HashSet<Orders>();
	
	public Customer(String address, String city, String zip, String state, String country, String phone, String gender)
	{
		this.customerAddress=address;
		this.customerCity=city;
		this.customerZip=zip;
		this.customerState=state;
		this.customerCountry=country;
		this.customerPhone=phone;
		this.customerGender=gender;
		
		//this.orders=new HashSet<Orders>();
	}
	
	Customer(){
	}
	
//	public Set<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	


	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerZip() {
		return customerZip;
	}

	public void setCustomerZip(String customerZip) {
		this.customerZip = customerZip;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	
}
