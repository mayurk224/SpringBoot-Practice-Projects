package com.expensetracker.expense.service;

import com.expensetracker.expense.dto.CategoryDto;
import com.expensetracker.expense.entity.Category;

import java.util.List;


public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId);

    List<CategoryDto> getAllCategory();

    CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);
}
