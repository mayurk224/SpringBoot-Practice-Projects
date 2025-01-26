package com.expensetracker.expense.controller;

import com.expensetracker.expense.dto.CategoryDto;
import com.expensetracker.expense.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping( "/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long categoryId){
        CategoryDto category = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(category);
    }
}
