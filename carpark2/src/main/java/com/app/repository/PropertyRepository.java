package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Property;

@Repository

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	List<Property> findAllByCity(String city);

}
