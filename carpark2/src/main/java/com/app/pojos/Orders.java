package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orders 
{
	private Integer id;
	private Status status;
	private Date bookingdate;
	private Date enddate;

	private User user;
	private Property property;
	private Transactions txn;
	
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}


	public Orders(Status status, Date booking_date, Date end_date) {
		super();
		this.status = status;
		this.bookingdate = booking_date;
		this.enddate=end_date;
	}

	//FK mapping starts here

	@ManyToOne
	@JoinColumn(name = "user")
	public User getUser() {
		return user;
	}

	public void setUser(User user_id) {
		this.user = user_id;
	}

	@ManyToOne
	@JoinColumn(name = "property")
	public Property getProperty() {
		return property;
	}


	public void setProperty(Property property_id) {
		this.property = property_id;
	}
	
	@OneToOne
	@JoinColumn(name = "transactionid")
	public Transactions getTxn() {
		return txn;
	}

	
	public void setTxn(Transactions txn) {
		this.txn = txn;
	}
	
	//FK mapping ends here

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Date getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	
	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	
	
}
