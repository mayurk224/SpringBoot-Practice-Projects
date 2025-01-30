package com.springbootproject.todo.service;

import com.springbootproject.todo.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
}
