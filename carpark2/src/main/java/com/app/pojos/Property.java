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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Property 
{
	private Integer id;
	
	private BigDecimal lat;
	private BigDecimal lng;
	
	private String houseno;
	private String streetname;
	
	private String city;
	private String state;
	
	private int capacity;
	private Date pregdate;
	
	private Status status;
	
	@Lob
	@Column(columnDefinition="CLOB")
	private String description;
	
	@Lob
	@Column(columnDefinition="BLOB", nullable = false)
	@NotNull
	private byte[] image;
	
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

	public void setImage(byte[] image) {
		this.image = image;
	}

	private User owner;
		
	

	@JsonIgnore
	private List<Reviews> reviews = new ArrayList<>();
	
	@JsonIgnore
	private List<Orders> order_id = new ArrayList<>();
	
	
	
	public Property() {
		this.capacity=1;
	}



	
	//FK mapping starts here
	

	
	

	public Property(String description ,int capacity , BigDecimal lat, BigDecimal lng, String house_no, String street_name, String city, String state, Date propertyreg_date, Status status) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.houseno = house_no;
		this.streetname = street_name;
		this.city = city;
		this.state = state;
		this.pregdate = propertyreg_date;
		this.status=status;
		this.capacity=capacity;
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne
	@JoinColumn(name = "owner")
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner_id) {
		this.owner = owner_id;
	}

	

	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	//inverse side is here
	@OneToMany(mappedBy = "property",cascade = CascadeType.ALL,orphanRemoval = true)
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
	public String getHouseno() {
		return houseno;
	}

	public void setHouseno(String house_no) {
		this.houseno = house_no;
	}
	
	@Column(length = 50)
	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String street_name) {
		this.streetname = street_name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getPregdate() {
		return pregdate;
	}

	public void setPregdate(Date propertyreg_date) {
		this.pregdate = propertyreg_date;
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

	
	
}
