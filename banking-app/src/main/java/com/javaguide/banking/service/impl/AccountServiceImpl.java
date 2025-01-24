package com.javaguide.banking.service.impl;

import com.javaguide.banking.dto.AccountDto;
import com.javaguide.banking.dto.TransactionDto;
import com.javaguide.banking.dto.TransferFundDto;
import com.javaguide.banking.entity.Account;
import com.javaguide.banking.entity.Transaction;
import com.javaguide.banking.exception.AccountException;
import com.javaguide.banking.mapper.AccountMapper;
import com.javaguide.banking.repository.AccountRepository;
import com.javaguide.banking.repository.TransactionRepository;
import com.javaguide.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    private static final String TRANSACTION_TYPE_DEPOSIT = "DEPOSIT";
    private static final String TRANSACTION_TYPE_WITHDRAW = "WITHDRAW";
    private static final String TRANSACTION_TYPE_TRANSFER = "TRANSFER";

    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
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

        Transaction transaction = new Transaction();
        transaction.setAccountId(id);
        transaction.setAmount(amount);
        transaction.setTransactionType(TRANSACTION_TYPE_DEPOSIT);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);

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

        Transaction transaction = new Transaction();
        transaction.setAccountId(id);
        transaction.setAmount(amount);
        transaction.setTransactionType(TRANSACTION_TYPE_WITHDRAW);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);

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

        Transaction transaction = new Transaction();
        transaction.setAccountId(transferFundDto.fromAccountId());
        transaction.setAmount(transferFundDto.amount());
        transaction.setTransactionType(TRANSACTION_TYPE_TRANSFER);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionDto> getAccountTransactions(Long accountId) {
        // Check if the account exists
        boolean accountExists = accountRepository.existsById(accountId);
        if (!accountExists) {
            throw new AccountException("Account with ID " + accountId + " does not exist.");
        }

        // Retrieve transactions if the account exists
        List<Transaction> transactions = transactionRepository.findByAccountIdOrderByTimestampDesc(accountId);

        return transactions.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


    private TransactionDto convertEntityToDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getAccountId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTimestamp()
        );
    }

}
