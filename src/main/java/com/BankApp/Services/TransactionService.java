package com.BankApp.Services;

import com.BankApp.DAO.TransactionDAO;
import com.BankApp.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionDAO transactionDAO;

    @Autowired
    public TransactionService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    //TODO Get all transactions
    public List<Transaction> getAllTransactions(){
        return transactionDAO.findAll();
    }

    // TODO Retrieve all transactions for a specific account
    public Optional<Transaction> getTransactionsByAccountId(int accountId) {
        return transactionDAO.findById(accountId);
    }

    //TODO Retrieve transaction details by transaction ID
   public Optional<Transaction> getTransactionById(int transactionId){
        return transactionDAO.findById(transactionId);
   };

}
