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

import com.app.pojos.Reviews;
import com.app.pojos.Transactions;
import com.app.service.ITxnService;

@RestController
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/txn")
public class TransactionController {
	
	@Autowired
	private ITxnService txnservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTxn(
									@RequestParam(value="amount") float amount,
									@RequestParam(value="txnNumber") String txnNumber,
									@RequestParam(value="txndate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date txndate
									) {

		Transactions r = new Transactions(amount, txnNumber, txndate);
		
		return new ResponseEntity<Transactions>(txnservice.addTxn(r), HttpStatus.OK);
	}
	
	@GetMapping("/listall")
	public ResponseEntity<?> listall() {
		return new ResponseEntity<List<Transactions>>(txnservice.listAll(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findTxn(
									@PathVariable int id
										) {
		return new ResponseEntity<Transactions>(txnservice.findTxn(id), HttpStatus.OK);
		
	}
	

}
