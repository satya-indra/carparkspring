package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User 
{
	private Integer id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	
	@Transient
	private String newPassword;
	

	private Date dob;
	private UserType type;
	private Date regdate;
	
	
	@JsonIgnore
	List<Property> property_id = new ArrayList<>();
	
	@JsonIgnore
	List<Orders> order_id = new ArrayList<>();
	
	@JsonIgnore
	List<Reviews> review_id = new ArrayList<>();
	
	public User() {
	}
	
	public User(int id) {
	}


	public User(String fname, String lname, String email, String password, Date dob, UserType type, Date regdate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.type = type;
		this.regdate = regdate;
	}
	
	//***********************************************************************

	// FK mapping starts

	
	
	@OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Property> getProperty_id() {
		return property_id;
	}

	public void setProperty_id(List<Property> property_id) {
		this.property_id = property_id;
	}

	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Orders> getOrder_id() {
		return order_id;
	}

	public void setOrder_id(List<Orders> order_id) {
		this.order_id = order_id;
	}

	@OneToMany(mappedBy ="user_id",cascade = CascadeType.ALL,orphanRemoval = true )
	public List<Reviews> getReview_id() {
		return review_id;
	}

	public void setReview_id(List<Reviews> review_id) {
		this.review_id = review_id;
	}
	
	//************************************************************************

		// FK mapping ends

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Transient
	public String getNewPassword() {
		return newPassword;
	}

	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Enumerated(EnumType.STRING )
	public UserType getType() {
		return type;
	}


	public void setType(UserType type) {
		this.type = type;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", dob=" + dob + ", type=" + type + ", regdate=" + regdate + "]";
	}
	
	public void addProperty(Property property)
	{
		property_id.add(property);		
		property.setOwner_id(this);
	}
	
	
	public void removeProperty(Property property)
	{
		property_id.remove(property);
		property.setOwner_id(null);
	}
	
	
}
