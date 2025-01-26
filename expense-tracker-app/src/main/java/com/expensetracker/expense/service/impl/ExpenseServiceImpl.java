package com.expensetracker.expense.service.impl;

import com.expensetracker.expense.dto.ExpenseDto;
import com.expensetracker.expense.entity.Expense;
import com.expensetracker.expense.mapper.ExpenseMapper;
import com.expensetracker.expense.repository.ExpenseRepository;
import com.expensetracker.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense saveExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(saveExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(
                ()-> new RuntimeException("Expense not found with id"+expenseId)
        );
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(
                (expense)->ExpenseMapper.mapToExpenseDto(expense)
        ).collect(Collectors.toList());
    }
}
