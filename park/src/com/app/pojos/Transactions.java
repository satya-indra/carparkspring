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

@Entity
public class Transactions 
{
	private Integer id;
	private Status tx_status;
	private float amount;
	private Date txn_date;
	private TransactionType transaction_type; 
	 private Orders order_id;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(Status tx_status, float amount, Date txn_date, TransactionType transaction_type) {
		super();
		this.tx_status = tx_status;
		this.amount = amount;
		this.txn_date = txn_date;
		this.transaction_type = transaction_type;
	}
	
	// FK mapping starts
	
	@OneToOne(mappedBy = "txn_id",cascade = CascadeType.ALL,orphanRemoval = true)
	public Orders getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Orders order_id) {
		this.order_id = order_id;
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

	@Enumerated(EnumType.STRING)
	public Status getTx_status() {
		return tx_status;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	public void setTx_status(Status tx_status) {
		this.tx_status = tx_status;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTxn_date() {
		return txn_date;
	}

	public void setTxn_date(Date txn_date) {
		this.txn_date = txn_date;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	public TransactionType getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", tx_status=" + tx_status + ", amount=" + amount + ", txn_date=" + txn_date
				+ ", transaction_type=" + transaction_type + "]";
	}
	
	
	

}
