package com.expensetracker.expense.controller;

import com.expensetracker.expense.dto.ExpenseDto;
import com.expensetracker.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("{expenseId}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long expenseId){
        ExpenseDto expense = expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expense);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }
}
