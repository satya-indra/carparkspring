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
	
	private Status status;
	
	@Lob
	@Column(columnDefinition="BLOB")
	private byte[] image;
	
	
	@JsonIgnore
	List<Property> property = new ArrayList<>();
	
	@JsonIgnore
	List<Orders> order = new ArrayList<>();
	
	@JsonIgnore
	List<Reviews> review = new ArrayList<>();
	
	public User(String fname2, String lname2, String email2, String password2, Status status2, UserType type2) {
	
		super();
		this.fname = fname2;
		this.lname = lname2;
		this.email = email2;
		this.password = password2;
		this.status=status2;
		this.type=type2;
	}
	
	public User() {
	}


	public User(Status status, byte[] image, String fname, String lname, String email, String password, Date dob, UserType type, Date regdate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.type = type;
		this.regdate = regdate;
		this.image = image;
		this.status=status;
	}
	
	//***********************************************************************

	// FK mapping starts

	public User(String fileName, String contentType, byte[] bytes) {
		// TODO Auto-generated constructor stub
	}

	public User(String fname2, String lname2, String email2, String password2, Status status2, UserType type2,
			Date regdate2, Date dob2) {
		super();
		this.fname = fname2;
		this.lname = lname2;
		this.email = email2;
		this.password = password2;
		this.status=status2;
		this.type=type2;
		this.dob=dob2;
		this.regdate=regdate2;
		
		// TODO Auto-generated constructor stub
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] bs) {
		this.image = bs;
	}

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property_id) {
		this.property = property_id;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order_id) {
		this.order = order_id;
	}

	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL,orphanRemoval = true )
	public List<Reviews> getReview() {
		return review;
	}

	public void setReview(List<Reviews> review_id) {
		this.review = review_id;
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

	
	@Temporal(TemporalType.DATE)
	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

	

	
}
