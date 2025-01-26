package com.expensetracker.expense.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseDto(Long id,
                         BigDecimal amount,
                         LocalDateTime expenseDate,
                         CategoryDto categoryDto) {
}
