package com.BankApp.Exceptions.Accounts;

public class AccountExists extends Exception{
    public AccountExists(String message){
        super(message);
    }
}
