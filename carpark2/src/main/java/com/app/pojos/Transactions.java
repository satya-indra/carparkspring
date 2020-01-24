package com.app.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Transactions 
{
	private Integer id;
	private String txnNumber;
	private float amount;
	private Date txndate;

	private Orders orders;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(float amount, String txnNumber, Date txndate) {
		super();
		this.txnNumber = txnNumber;
		this.amount = amount;
		this.txndate = txndate;
	}
	
	// FK mapping starts
	

	@OneToOne(mappedBy = "txn",cascade = CascadeType.ALL,orphanRemoval = true)
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	// FK mapping ends

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTxndate() {
		return txndate;
	}

	public void setTxndate(Date txn_date) {
		this.txndate = txn_date;
	}
	
	@Column(length = 50)
	public String getTxnNumber() {
		return txnNumber;
	}

	public void setTxnNumber(String txnNumber) {
		this.txnNumber = txnNumber;
	}
	
	

}
