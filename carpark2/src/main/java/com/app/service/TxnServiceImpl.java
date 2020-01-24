package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Transactions;
import com.app.repository.TxnRepository;

@Service
@Transactional
public class TxnServiceImpl implements ITxnService {

	@Autowired
	private TxnRepository txnRepo;
	
	@Override
	public Transactions addTxn(Transactions r) {
		return txnRepo.save(r);
	}

	@Override
	public List<Transactions> listAll() {
		
		return txnRepo.findAll();
	}

	@Override
	public Transactions findTxn(int id) {
		return txnRepo.getOne(id);
	}

}
