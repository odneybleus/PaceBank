package com.BankApp.Services;

import com.BankApp.DAO.AccountDAO;
import com.BankApp.Exceptions.Accounts.AccountExists;
import com.BankApp.Exceptions.Accounts.NotEnoughFunds;
import com.BankApp.Models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //TODO Get All Account
    public List<Account> getAllAccounts(){
        return accountDAO.findAll();
    }

    //TODO Create New Account
    public Account createAccount(Account account){
        return accountDAO.save(account);
    }

    //TODO get Accounts By User Id
    public Optional<Account> getAccountById(int id){
        return accountDAO.findById(id);
    }
    // TODO Update Account
    //TODO Delete Account
    public void deleteAccount(Account account){
        accountDAO.delete(account);
    }

    //TODO Deposit Money into account
    public Account deposit(int accountId, Double amount) throws AccountNotFoundException {
        Optional<Account> possibleAccount = accountDAO.findById(accountId);

        if(possibleAccount.isPresent()){
            Account actualAccount = possibleAccount.get();
            double newBalance = actualAccount.getBalance() + amount;
            actualAccount.setBalance(newBalance);
            return accountDAO.save(actualAccount);


        }else{
            throw new AccountNotFoundException("Account not found with ID " + accountId);
        }
    }
    //TODO withDraw money from account
    public Account withdraw(int accountId, Double amount) throws AccountNotFoundException, NotEnoughFunds {
        Optional<Account> possibleAccount = accountDAO.findById(accountId);

        if (possibleAccount.isPresent()) {
            Account actualAccount = possibleAccount.get();

            if(actualAccount.getBalance() >= amount){
                double newBalance = actualAccount.getBalance() - amount;
                actualAccount.setBalance(newBalance);
                return accountDAO.save(actualAccount);
            } else {
                // Throw an exception for insufficient funds
                throw new NotEnoughFunds("Insufficient funds for account ID " + accountId);
            }
        } else {
            // Throw an exception if the account is not found
            throw new AccountNotFoundException("Account not found with ID " + accountId);
        }
    }
    //TODO transfer money from account to account
    //TODO get account balance
}
