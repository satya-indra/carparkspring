package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reviews {
	private Integer id;
	private String review;
	private int rating;
	private Date reg_date;
	
	private Property property_id;
	
	private User user_id;
	
	public Reviews() {
		// TODO Auto-generated constructor stub
	}

	public Reviews(String review, int rating, Date reg_date) {
		super();
		this.review = review;
		this.rating = rating;
		this.reg_date = reg_date;
	}
	
	// FK mapping starts

	@ManyToOne
	@JoinColumn(name="property_id")
	public Property getproperty_id() {
		return property_id;
	}

	public void setproperty_id(Property property_id) {
		this.property_id = property_id;
	}


	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	// FK mapping ends
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", review=" + review + ", rating=" + rating + ", reg_date=" + reg_date + "]";
	}
	
	
}