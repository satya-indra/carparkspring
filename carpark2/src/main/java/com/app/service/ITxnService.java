package com.app.service;

import java.util.List;

import com.app.pojos.Transactions;

public interface ITxnService {

	Transactions addTxn(Transactions r);

	List<Transactions> listAll();

	Transactions findTxn(int id);

}
