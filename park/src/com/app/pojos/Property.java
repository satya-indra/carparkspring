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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.*;

@Entity
public class Property 
{
	private Integer id;
	private String house_no;
	private String street_name;
	private int capacity;
	private Date propertyreg_date;	
	private User owner_id;
	
	private City city_id;
	
	private List<Reviews> reviews = new ArrayList<>();
	
	private List<Orders> order_id = new ArrayList<>();
	
	private Location location_id;
	
	
	public Property() {
		this.capacity=1;
	}

	public Property(String house_no, String street_name,  int capacity, Date propertyreg_date) {
		super();
		this.house_no = house_no;
		this.street_name = street_name;
		this.capacity = 1;
		this.propertyreg_date = propertyreg_date;
	}

	//FK mapping starts here

	@OneToOne
	@JoinColumn(name = "owner_id")
	public User getowner_id() {
		return owner_id;
	}

	public void setowner_id(User owner_id) {
		this.owner_id = owner_id;
	}

	//********************************************************//
	//INVERSE side is mapped with OWNING side. 
	@ManyToOne
	@JoinColumn(name = "city_id")
	public City getcity_id() {
		return city_id;
	}

	public void setcity_id(City city_id) {
		this.city_id = city_id;
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

	@OneToOne(mappedBy = "property_id",cascade = CascadeType.ALL,orphanRemoval = true)
	public Location getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Location location_id) {
		this.location_id = location_id;
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
	public Date getpropertyreg_date() {
		return propertyreg_date;
	}

	public void setpropertyreg_date(Date propertyreg_date) {
		this.propertyreg_date = propertyreg_date;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", house_no=" + house_no + ", street_name=" + street_name +  ", capacity=" + capacity + ", propertyreg_date=" + propertyreg_date + "]";
	}
	
	

}
