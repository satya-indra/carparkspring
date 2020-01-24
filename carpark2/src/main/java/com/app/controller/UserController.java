package com.app.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.pojos.Status;
import com.app.pojos.User;
import com.app.pojos.UserType;
import com.app.service.IUserService;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private IUserService userservice;
	
	
	public static String uploadLocation=System.getProperty("user.dir")+"/uploads";
	
	@PostMapping("/adduser")
	public ResponseEntity<?> userAdd(	@RequestParam(value="fname") String fname,
										@RequestParam(value="lname") String lname,
										@RequestParam(value="email") String email,
										@RequestParam(value="password") String password,
										@RequestParam(value="dob") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dob,
										@RequestParam(value="regdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date regdate,
										@RequestParam(value="status") Status status,
										@RequestParam(value="type") UserType type,
										@RequestParam(value="image") MultipartFile image){
		
		System.out.println("in useradd ");
		System.out.println("in process upload "+uploadLocation);
		
		try {
			User u = new User( fname, lname, email, password, status, type, regdate, dob);
			if (image != null) {
				u.setImage(image.getBytes());
			}
			return new ResponseEntity<User>(userservice.addUser(u), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(
											@RequestParam(value="email") String email,
											@RequestParam(value="password") String password ) {
		return new ResponseEntity<User>(userservice.validateUser(email, password), HttpStatus.OK);
		
	}
	
	@GetMapping("/userlist")
	public  ResponseEntity<?> userList() {
		return new ResponseEntity<List<User>>(userservice.userList(), HttpStatus.OK);
	}
	
	@PutMapping("/userdelete")
	public ResponseEntity<?> userDelete(	@RequestParam(value="id") int id
											) {
		return new ResponseEntity<User>(userservice.userDelete(id), HttpStatus.OK);
	}
	
	
	
	

}
