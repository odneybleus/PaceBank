package com.BankApp.Exceptions.Accounts;

public class NotEnoughFunds extends  Exception{
    public NotEnoughFunds(String message){
        super(message);
    }
}
