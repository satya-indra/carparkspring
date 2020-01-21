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
public class UserVehicle {
	private Integer id;
	private String vehicle_no;
	private Date reg_date;
	
	User user_id;
	
	public UserVehicle() {
		// TODO Auto-generated constructor stub
	}

	public UserVehicle(String vehicle_no, Date reg_date) {
		super();
		this.vehicle_no = vehicle_no;
		this.reg_date = reg_date;
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
	
	//FK mapping ends here


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 50)
	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	
	
	
	
}
