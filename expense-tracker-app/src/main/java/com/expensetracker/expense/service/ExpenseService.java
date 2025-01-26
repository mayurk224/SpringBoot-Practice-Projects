package com.expensetracker.expense.service;

import com.expensetracker.expense.dto.ExpenseDto;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);
}
