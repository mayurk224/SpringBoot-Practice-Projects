package com.expensetracker.expense.service.impl;

import com.expensetracker.expense.dto.CategoryDto;
import com.expensetracker.expense.entity.Category;
import com.expensetracker.expense.mapper.CategoryMapper;
import com.expensetracker.expense.repository.CategoryRepository;
import com.expensetracker.expense.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new RuntimeException("Category not found with id:"+categoryId)
        );
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category)->CategoryMapper.mapToCategoryDto(category)).collect(Collectors.toList());

    }
}
