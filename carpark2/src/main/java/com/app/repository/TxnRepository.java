package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Transactions;

@Repository

public interface TxnRepository extends JpaRepository<Transactions, Integer> {

}
