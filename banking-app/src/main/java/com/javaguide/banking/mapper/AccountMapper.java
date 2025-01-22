package com.javaguide.banking.mapper;

import com.javaguide.banking.dto.AccountDto;
import com.javaguide.banking.entity.Account;

public class AccountMapper {

    private AccountMapper() {
        // Private constructor to prevent instantiation
    }

    // Map AccountDto to Account entity
    public static Account mapToAccount(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId() != null ? accountDto.getId() : null)  // Handle null ID
                .accountHolderName(accountDto.getAccountHolderName())
                .balance(accountDto.getBalance())
                .build();
    }


    // Map Account entity to AccountDto
    public static AccountDto mapToAccountDto(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
