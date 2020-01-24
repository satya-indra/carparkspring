package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Property;
import com.app.pojos.User;

@Repository
public class PropertyDaoImpl implements IPropertyDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public Property addProperty(Property property, int id) {
		System.out.println("dao/addproperty"+getClass().getName()+id+property.toString());
		
		UserImpl dao = new UserImpl();
		User u = dao.findUser(id);
		
		u.addProperty(property);	
		sf.getCurrentSession().update(u);
		sf.getCurrentSession().persist(property);
		return property;
	}
	
	

}
