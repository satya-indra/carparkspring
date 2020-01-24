package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPropertyDao;
import com.app.pojos.Property;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService {
	
	@Autowired
	IPropertyDao dao;

	@Override
	public Property addProperty(Property property, int id) {
		return dao.addProperty(property, id);
	}

}
