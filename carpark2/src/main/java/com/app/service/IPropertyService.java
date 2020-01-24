package com.app.service;

import java.util.List;

import com.app.pojos.Property;

public interface IPropertyService 
{

	Property addProperty(Property property, int id);

	List<Property> listAll();

	List<Property> findByCity(String city);

}
