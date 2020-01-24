package com.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Orders;
import com.app.pojos.Status;
import com.app.service.IOrderService;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private IOrderService orderservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addOrder(
									@RequestParam(value="status") Status status,
									@RequestParam(value="user") int user,
									@RequestParam(value="property") int property,
									@RequestParam(value="txn") int txn,
									@RequestParam(value="enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date enddate,
									@RequestParam(value="bookingdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date bookingdate
									) {
		Orders o = new Orders(status, bookingdate, enddate);
		return new ResponseEntity<Orders>(orderservice.addOrder(o, user, property, txn), HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> orderList() {
		return new ResponseEntity<List<Orders>>(orderservice.orderList(), HttpStatus.OK);
	}
	
	@GetMapping("/uorders/{userid}")
	public ResponseEntity<?> findUserOrder(
										@PathVariable int userid) {
		return new ResponseEntity<List<Orders>>(orderservice.findUserOrder(userid),HttpStatus.OK);
		
	}
	
	@GetMapping("/porders/{pid}")
	public ResponseEntity<?> findPropertyOrder(
												@PathVariable int pid) {
		return new ResponseEntity<List<Orders>>(orderservice.findPropertyOrder(pid), HttpStatus.OK);
	}

}
