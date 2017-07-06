package com.ebookportal.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="orderDetails_table")

public class OrderDetails {
	
	@Id
	@GeneratedValue
	@Column(name="orderDetailID")
	private long orderDetailID;

	//@OneToMany(fetch = FetchType.EAGER)
	@Column(name="orderID")
	private long orderId;
	
	@Column(name="bookId")
	private long bookId;
	
	@Column(name="customerId")
	private long customerId;
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="bookAuthor")
	private String bookAuthor;
	
	@Column(name="price")
	private float price;
	
	@Column(name="date")
	private String date;
	
	public OrderDetails(long bookId, long orderId, long customerId ,float price, String bookName, String bookAuthor, String date){
		this.bookId=bookId;
		this.orderId=orderId;
		this.customerId=customerId;
		this.price=price;
		this.bookName=bookName;
		this.bookAuthor=bookAuthor;
		this.date=date;
	}
	
	public OrderDetails(){
		
	}

	public long getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
