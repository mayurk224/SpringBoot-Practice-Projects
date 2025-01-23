package com.javaguide.banking.mapper;

import com.javaguide.banking.dto.AccountDto;
import com.javaguide.banking.entity.Account;

public class AccountMapper {

    private AccountMapper() {}

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()
        );
    }

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
