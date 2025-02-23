package com.javaguide.banking.repository;

import com.javaguide.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Custom query method to find an account by account holder name
}
