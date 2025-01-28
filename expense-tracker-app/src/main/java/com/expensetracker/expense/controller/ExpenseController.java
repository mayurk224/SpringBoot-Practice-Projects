package com.expensetracker.expense.controller;

import com.expensetracker.expense.dto.ExpenseDto;
import com.expensetracker.expense.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CURD REST API for expense resource",
        description = "crud rest api for expense resource "
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @Operation(
            summary = "create expense rest api",
            description = "create expense rest api to save a expense in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS - 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @Operation(
            summary = "get expense by id rest api",
            description = "get expense by id rest api to get expense by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 OK"
    )
    @GetMapping("{expenseId}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long expenseId){
        ExpenseDto expense = expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expense);
    }

    @Operation(
            summary = "get all expenses rest api",
            description = "get all expenses rest api to get all expenses from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @Operation(
            summary = "update expense by id rest api",
            description = "update expense rest api to update expense by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 OK"
    )
    @PutMapping("{expenseId}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long expenseId,@RequestBody ExpenseDto expenseDto){
        ExpenseDto updateExpense = expenseService.updateExpense(expenseId,expenseDto);
        return ResponseEntity.ok(updateExpense);
    }

    @Operation(
            summary = "delete expense by id rest api",
            description = "delete expense by id rest api to delete expense from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 CREATED"
    )
    @DeleteMapping("{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
