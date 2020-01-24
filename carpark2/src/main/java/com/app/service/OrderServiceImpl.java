package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Orders;
import com.app.pojos.Property;
import com.app.pojos.Transactions;
import com.app.pojos.User;
import com.app.repository.OrderRepository;
import com.app.repository.PropertyRepository;
import com.app.repository.TxnRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PropertyRepository propRepo ;
	
	@Autowired
	private TxnRepository txnRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public Orders addOrder(Orders o, int user, int property, int txn) {
		
		User u = userRepo.getOne(user);
		Property p = propRepo.getOne(property);
		Transactions t = txnRepo.getOne(txn);
		
		o.setUser(u);
		o.setProperty(p);
		o.setTxn(t);
		
		return orderRepo.save(o);
		}

	@Override
	public List<Orders> orderList() {
		return orderRepo.findAll();
	}

	@Override
	public List<Orders> findUserOrder(int userid) {

		return orderRepo.findAllByUser(userid);
		
	}

	@Override
	public List<Orders> findPropertyOrder(int pid) {

		return orderRepo.findAllByProperty(pid);
	}

	

}
