package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Property;
import com.app.pojos.User;
import com.app.service.IPropertyService;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/property")
public class PropertyController 
{
	@Autowired
	private IPropertyService service;
	
	@PutMapping("/add/{id}")
	public ResponseEntity<?> addProperty(@RequestBody Property property, @PathVariable int id )
	{

		System.out.println("inside addProperty"+getClass().getName());
				
		try {
			return new ResponseEntity<Property>(service.addProperty(property, id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	

}
