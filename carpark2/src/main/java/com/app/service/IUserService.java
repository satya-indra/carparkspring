package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.User;

public interface IUserService 
{
	
	User addUser(User u) throws Exception;

	User validateUser(String email, String password);

	List<User> userList();

	User userDelete(int id);
	 


}
