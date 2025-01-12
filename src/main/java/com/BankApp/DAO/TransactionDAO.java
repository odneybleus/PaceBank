package com.BankApp.DAO;

import com.BankApp.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAO extends JpaRepository<Transaction, Integer> {
}
