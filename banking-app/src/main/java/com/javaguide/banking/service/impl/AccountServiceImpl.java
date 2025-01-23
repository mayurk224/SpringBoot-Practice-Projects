package com.javaguide.banking.service.impl;

import com.javaguide.banking.dto.AccountDto;
import com.javaguide.banking.dto.TransferFundDto;
import com.javaguide.banking.entity.Account;
import com.javaguide.banking.exception.AccountException;
import com.javaguide.banking.mapper.AccountMapper;
import com.javaguide.banking.repository.AccountRepository;
import com.javaguide.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
        if (account.getBalance() < amount) {
            throw new AccountException("Insufficient balance");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
        accountRepository.deleteById(id);
    }

    @Override
    public void transferFunds(TransferFundDto transferFundDto) {
        // Fetch 'fromAccount' and validate its existence
        Account fromAccount = accountRepository.findById(transferFundDto.fromAccountId())
                .orElseThrow(() -> new AccountException("From account does not exist"));

        // Fetch 'toAccount' and validate its existence
        Account toAccount = accountRepository.findById(transferFundDto.toAccountId())
                .orElseThrow(() -> new AccountException("To account does not exist"));

        // Validate sufficient balance in 'fromAccount'
        if (fromAccount.getBalance() < transferFundDto.amount()) {
            throw new AccountException("Insufficient balance in from account");
        }

        // Validate positive transfer amount
        if (transferFundDto.amount() <= 0) {
            throw new AccountException("Transfer amount must be greater than zero");
        }

        // Perform the fund transfer
        fromAccount.setBalance(fromAccount.getBalance() - transferFundDto.amount());
        toAccount.setBalance(toAccount.getBalance() + transferFundDto.amount());

        // Save both accounts (transaction ensures atomicity)
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
