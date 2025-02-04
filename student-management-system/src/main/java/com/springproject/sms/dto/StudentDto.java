package com.springproject.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;

    @NotEmpty(message = "Student first name is required")
    private String firstName;

    @NotEmpty(message = "Student last name is required")
    private String lastName;

    @NotEmpty(message = "Student email is required")
    @Email(message = "Student email is not valid")
    private String email;
}
