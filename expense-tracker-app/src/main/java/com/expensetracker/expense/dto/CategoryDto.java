package com.expensetracker.expense.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO (Data Transfer Object) to transfer the data between client and server"
)
public record CategoryDto(Long id,
                          @Schema(
                                  description = "category name"
                          )
                          String name) {

}
