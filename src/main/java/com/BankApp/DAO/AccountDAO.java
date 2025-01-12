package com.BankApp.DAO;

import com.BankApp.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, Integer> {
}
