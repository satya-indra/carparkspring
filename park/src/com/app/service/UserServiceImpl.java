package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUser;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUser dao;

	@Override
	public User userValidation(User user) {
		System.out.println("inside service - user validation"+getClass().getName());
		return dao.userValidation(user);
	}

	@Override
	public User addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public List<User> getAllUser() 
	{
		return dao.getAllUser();
	}

}
