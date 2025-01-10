package com.BankApp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(unique = true)
    private String userName;

    @Column(unique = true, nullable = false)
    private String userEmail;


    private String userPassword;
    private String userAddress;
    private String userPhoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate createdDate;

    private List<Account> userAccounts;



}
