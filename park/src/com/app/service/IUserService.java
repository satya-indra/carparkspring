package com.app.service;

import java.util.List;


import com.app.pojos.User;

public interface IUserService 
{
	User userValidation(User user);
	User addUser(User user);
	List<User> getAllUser();

}
