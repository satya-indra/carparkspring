package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Reviews;

@Repository

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {

	Reviews findByUserAndProperty(int user, int property);

}
