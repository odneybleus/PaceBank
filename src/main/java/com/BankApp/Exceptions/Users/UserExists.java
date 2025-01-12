package com.BankApp.Exceptions.Users;

public class UserExists extends Exception{
    public UserExists(String message){
        super(message);
    }
}
