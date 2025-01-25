package com.expensetracker.expense.mapper;

import com.expensetracker.expense.dto.CategoryDto;
import com.expensetracker.expense.entity.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }

    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
