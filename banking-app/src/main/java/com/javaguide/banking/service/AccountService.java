package com.javaguide.banking.service;

import com.javaguide.banking.dto.AccountDto;

public interface AccountService {
    // Create a new account
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);
}
