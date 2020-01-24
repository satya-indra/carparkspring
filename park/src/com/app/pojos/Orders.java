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
	private Date booking_date;
	private Date end_date;

	private User user_id;
	private Property property_id;
	private Transactions txn_id;
	
	


	public Orders() {
		// TODO Auto-generated constructor stub
	}


	public Orders(Status status, Date booking_date, Date end_date) {
		super();
		this.status = status;
		this.booking_date = booking_date;
		this.end_date=end_date;
	}

	//FK mapping starts here

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	@ManyToOne
	@JoinColumn(name = "property_id")
	public Property getProperty_id() {
		return property_id;
	}


	public void setProperty_id(Property property_id) {
		this.property_id = property_id;
	}
	
	@OneToOne
	@JoinColumn(name = "transaction_id")
	public Transactions getTxn_id() {
		return txn_id;
	}

	
	public void setTxn_id(Transactions txn_id) {
		this.txn_id = txn_id;
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
	
	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	
	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", status=" + status + ", booking_date=" + booking_date + "]";
	}	
	
}
