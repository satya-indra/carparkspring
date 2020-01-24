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
	private Date regdate;
	
	private Property property;
	
	private User user;
	
	public Reviews() {
		// TODO Auto-generated constructor stub
	}

	public Reviews(String review, int rating, Date reg_date) {
		super();
		this.review = review;
		this.rating = rating;
		this.regdate = reg_date;
	}
	
	// FK mapping starts

	@ManyToOne
	@JoinColumn(name="property")
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


	@ManyToOne
	@JoinColumn(name="user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date reg_date) {
		this.regdate = reg_date;
	}

	
	
	
}
