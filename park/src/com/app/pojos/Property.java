package com.app.pojos;
import java.math.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Property 
{
	private Integer id;
	
	private BigDecimal lat;
	private BigDecimal lng;
	
	private String house_no;
	private String street_name;
	
	private String city;
	private String state;
	
	private int capacity;
	private Date propertyreg_date;
	
	private User owner_id;
		
	

	@JsonIgnore
	private List<Reviews> reviews = new ArrayList<>();
	
	@JsonIgnore
	private List<Orders> order_id = new ArrayList<>();
	
	
	
	public Property() {
		this.capacity=1;
	}

	public Property(String house_no, String street_name,  int capacity, Date propertyreg_date, BigDecimal lat, BigDecimal lng) {
		super();
		this.house_no = house_no;
		this.street_name = street_name;
		this.capacity = 1;
		this.propertyreg_date = propertyreg_date;
		this.lat=lat;
		this.lng=lng;
	}

	//FK mapping starts here
	

	
	

	@OneToOne
	@JoinColumn(name = "owner_id")
	public User getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(User owner_id) {
		this.owner_id = owner_id;
	}

	

	@OneToMany(mappedBy = "property_id", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	//inverse side is here
	@OneToMany(mappedBy = "property_id",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Orders> getOrder_id() {
		return order_id;
	}

	public void setOrder_id(List<Orders> order_id) {
		this.order_id = order_id;
	}

	
	
	//********************************************************//
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
	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	
	@Column(length = 50)
	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getPropertyreg_date() {
		return propertyreg_date;
	}

	public void setPropertyreg_date(Date propertyreg_date) {
		this.propertyreg_date = propertyreg_date;
	}
	
	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lon) {
		this.lng = lon;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", house_no=" + house_no + ", street_name=" + street_name +  ", capacity=" + capacity + ", propertyreg_date=" + propertyreg_date + "]";
	}
	
	public void addUser(User user)
	{
	
		
	}
	
	
	
	
	
	

}
