package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
public class UserImpl implements IUser 
{
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public User userValidation(User user) 
	{
		String jpql = "select u from User u where u.email=:email and u.password=:password";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("email",user.getEmail()).setParameter("password",user.getPassword()).getSingleResult();
	}


	@Override
	public User addUser(User user) 
	{
		System.out.println("inside addUser"+ getClass().getName() +" " + user.toString());
		sf.getCurrentSession().persist(user);
		return user;
	}


	@Override
	public List<User> getAllUser() {
		String jpql = "select u from User u";
		return sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
	}


	@Override
	public User findUser(int id) {
		System.out.println("dao/userimpl/finduser" + getClass().getName()+" "+id);
		String jpql = "select u from User u where u.id=:id";
		
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("id", id).getSingleResult();
	}
	
	
	
	


}
