package com.expensetracker.expense.controller;

import com.expensetracker.expense.dto.CategoryDto;
import com.expensetracker.expense.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST apis for category resource",
        description = "crud rest api for category resource handling"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Operation(
            summary = "Create Category Rest api",
            description = "Create category rest api to save category into database"
    )
    @ApiResponse(
      responseCode = "201",
      description = "HTTP STATUS - 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @Operation(
            summary = "Get Category By id Rest api",
            description = "Get category by id rest api to get category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 OK"
    )
    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long categoryId){
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @Operation(
            summary = "Get All Categories Rest api",
            description = "Get all categories rest api to get all category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getALlCategories(){
        List<CategoryDto> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @Operation(
            summary = "Update Category by id Rest api",
            description = "Update category rest api to update category by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 OK"
    )
    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long categoryId,@RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory = categoryService.updateCategory(categoryId,categoryDto);
        return ResponseEntity.ok(updatedCategory);
    }

    @Operation(
            summary = "Delete Category by id Rest api",
            description = "Delete category rest api to delete category by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS - 200 OK"
    )
    @DeleteMapping("{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted Succesffully");
    }
}
