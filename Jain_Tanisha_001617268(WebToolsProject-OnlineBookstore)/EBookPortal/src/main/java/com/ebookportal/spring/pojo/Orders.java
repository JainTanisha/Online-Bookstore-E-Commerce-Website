package com.ebookportal.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Orders {
	
	@Id
	@GeneratedValue
	@Column(name="orderID")
	private long orderID;
	
//	@Column(name="bookId")
//	private long bookId;
	
//	@ManyToOne(fetch=FetchType.EAGER, mappedBy="orders", cascade=CascadeType.ALL)
//    private OrderDetails orderDetails;
//------------	
	@Column(name="customerId")
	private long customerId;
	
	@Column(name="itemNumber")
	private int itemNumber;
	
//	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@Column(name="customerId")
//	private Customer customerId;
	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="bookID")
//	@JoinColumn(name="bookId")
//	private Set<Book> books = new HashSet<Book>();
//	
//	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name="customerId")
//	private Customer customer;
	
	@Column(name="orderDate")
	private String orderDate;
	
	public Orders(long customerId, String orderDate, int itemNumber){
		this.itemNumber=itemNumber;
		this.customerId=customerId;
		this.orderDate = orderDate;
		//this.bookId=bookId;
		//this.books= new HashSet<Book>();
	}
	
	public Orders(){
	}
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

//	public long getBookId() {
//		return bookId;
//	}
//
//	public void setBookId(long bookId) {
//		this.bookId = bookId;
//	}
//=======
//	public long getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}

}


//package com.ebookportal.spring.pojo;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="orders_table")
//public class Orders {
//	
//	@Id
//	@GeneratedValue
//	@Column(name="ordersID")
//	private long ordersID;
//	
////	@JoinColumn(name="customerID")
////    private long customerID;
//	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="bookID")
//	@JoinColumn(name="book")
//	private Set<Book> books = new HashSet<Book>();
//	
//	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name="customer")
//	private Customer customer;
//	
//	Orders(){
//	}
//	
//	public Orders (Customer customer){
//		this.customer = customer;
//		this.books= new HashSet<Book>();
//	}
//
//	public long getOrdersID() {
//		return ordersID;
//	}
//
//	public void setOrdersID(long ordersID) {
//		this.ordersID = ordersID;
//	}
//
////	public long getCustomerID() {
////		return customerID;
////	}
////
////	public void setCustomerID(long customerID) {
////		this.customerID = customerID;
////	}
//
//	public Set<Book> getBooks() {
//		return books;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public void setBooks(Set<Book> books) {
//		this.books = books;
//	}
//
////	public String getDate() {
////		return date;
////	}
////
////	public void setDate(String date) {
////		this.date = date;
////	}
//}
