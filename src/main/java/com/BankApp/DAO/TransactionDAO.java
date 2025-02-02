package com.BankApp.DAO;

import com.BankApp.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDAO extends JpaRepository<Transaction, Integer> {

}
