package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUser;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private IUserService userservice;
	
	@PostMapping("/login")
	public ResponseEntity<?> userValidation(@RequestBody User user)
	{
		
		System.out.println("in uservalidation "+ user);
		try {
			return new ResponseEntity<User>(userservice.userValidation(user), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/adduser")
	public ResponseEntity<?> userAdd(@RequestBody User user)
	{
		System.out.println("in useradd "+ user.toString());
		try {
			return new ResponseEntity<User>(userservice.addUser(user),HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/userlist")
	public ResponseEntity<?> userList()
	{
		System.out.println("in get userlist service");
		List<User> userList = userservice.getAllUser();
		if (userList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	

}
