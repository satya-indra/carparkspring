package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IUser 
{
	User userValidation(User user);
	User addUser(User user);
	List<User> getAllUser();
	User findUser(int id);
}
