package com.app.service;

import java.util.List;

import com.app.pojos.Orders;

public interface IOrderService {

	Orders addOrder(Orders o, int user, int property, int txn);

	List<Orders> orderList();

	List<Orders> findUserOrder(int userid);

	List<Orders> findPropertyOrder(int pid);

}
