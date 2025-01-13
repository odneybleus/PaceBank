package com.BankApp.DAO;

import com.BankApp.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDAO extends JpaRepository<Account, Integer> {


}
