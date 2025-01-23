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
import java.util.Objects;
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
                .map(AccountMapper::mapToAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountException("Account does not exist"));
        accountRepository.deleteById(id);
    }

    @Override
    public void transferFunds(TransferFundDto transferFundDto) {
        // Check if 'fromAccountId' and 'toAccountId' are the same
        if (Objects.equals(transferFundDto.fromAccountId(), transferFundDto.toAccountId())) {
            throw new IllegalArgumentException("Transfer to the same account is not allowed");
        }

        // Retrieve 'from' and 'to' accounts
        Account fromAccount = accountRepository.findById(transferFundDto.fromAccountId()).orElseThrow(
                () -> new AccountException("From account does not exist")
        );
        Account toAccount = accountRepository.findById(transferFundDto.toAccountId()).orElseThrow(
                () -> new AccountException("To account does not exist")
        );

        // Check for sufficient balance in 'from' account
        if (fromAccount.getBalance() < transferFundDto.amount()) {
            throw new AccountException("Insufficient balance in account ID: " + fromAccount.getId());
        }

        // Perform the fund transfer
        fromAccount.setBalance(fromAccount.getBalance() - transferFundDto.amount());
        toAccount.setBalance(toAccount.getBalance() + transferFundDto.amount());

        // Save the updated accounts
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }

}
