package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Orders;

@Repository

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findAllByUser(int userid);

	List<Orders> findAllByProperty(int pid);

}
