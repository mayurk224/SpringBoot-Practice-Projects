package com.expensetracker.expense.service.impl;

import com.expensetracker.expense.dto.ExpenseDto;
import com.expensetracker.expense.entity.Expense;
import com.expensetracker.expense.mapper.ExpenseMapper;
import com.expensetracker.expense.repository.ExpenseRepository;
import com.expensetracker.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
