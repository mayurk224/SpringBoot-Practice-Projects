package com.expensetracker.expense.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "Error Details DTO (Data Transfer Object) to transfer the error response data between client and server"
)
@Getter
@Setter
public class ErrorDetails {
    @Schema(
            description = "Error occur date time"
    )
    private LocalDateTime timestamp;
    @Schema(
            description = "error message"
    )
    private String message;
    @Schema(
            description = "error details"
    )
    private String details;
    @Schema(
            description = "error code"
    )
    private String errorCode;
}
