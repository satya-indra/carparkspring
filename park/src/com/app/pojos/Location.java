package com.app.pojos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Location 
{
	private Integer id;
	private BigDecimal lat;
	private BigDecimal lon;
	
	Property property_id;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}

	public Location(BigDecimal lat, BigDecimal lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	
	//FK mapping starts here

	@OneToOne
	@JoinColumn(name="property_id")
	public Property getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Property property_id) {
		this.property_id = property_id;
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

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", lat=" + lat + ", lon=" + lon + "]";
	}
	
	

}
