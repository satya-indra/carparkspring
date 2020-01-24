package com.app.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Property;
import com.app.pojos.Status;
import com.app.pojos.User;
import com.app.pojos.UserType;
import com.app.service.IPropertyService;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/property")
public class PropertyController 
{
	@Autowired
	private IPropertyService service;
	
//	@PostMapping("/add/{id}")
//	public ResponseEntity<?> addProperty(@RequestBody Property property, @PathVariable int id )
//	{
//
//		System.out.println("inside addProperty"+getClass().getName());
//				
//		try {
//			return new ResponseEntity<Property>(service.addProperty(property, id), HttpStatus.ACCEPTED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//		
//		
//	}
//	
	@PostMapping("/add")
	public ResponseEntity<?> addProperty(
										@RequestParam(value="lat") BigDecimal lat,
										@RequestParam(value="lng") BigDecimal lng,
										@RequestParam(value="house_no") String house_no,
										@RequestParam(value="street_name") String street_name,
										@RequestParam(value="city") String city,
										@RequestParam(value="state") String state,
										@RequestParam(value="capacity") int capacity,
										@RequestParam(value="propertyreg_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date propertyreg_date,
										@RequestParam(value="image") MultipartFile image,
										@RequestParam(value="status") Status status,
										@RequestParam(value="description") String description,
										@RequestParam(value="userid") int userid )
	{

		System.out.println("inside addProperty"+getClass().getName());
				
		try {
			Property property = new Property(description,capacity, lat, lng, house_no, street_name, city,  state, propertyreg_date, status);
			if(image != null) {
				property.setImage(image.getBytes());
			}
			return new ResponseEntity<Property>(service.addProperty(property, userid), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<List<Property>>(service.listAll(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{city}")
	public ResponseEntity<?> findByCity(
										@PathVariable String city){ 
		return new ResponseEntity<List<Property>>(service.findByCity(city), HttpStatus.OK);
	}
	

}
