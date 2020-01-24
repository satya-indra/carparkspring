package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Property;
import com.app.pojos.User;
import com.app.repository.PropertyRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PropertyRepository propRepo ;

	@Override
	public Property addProperty(Property property, int id) {
		User user = userRepo.getOne(id);
		System.out.println(user.getFname());
		property.setOwner(user);
		propRepo.save(property);
		
		return property ;
	}

	@Override
	public List<Property> listAll() {
		return propRepo.findAll();
	}

	@Override
	public List<Property> findByCity(String city) {

		return propRepo.findAllByCity(city);
	}
	


	
}
