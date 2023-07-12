package com.csc.api.controller;

import com.csc.api.model.entity.Category;
import com.csc.api.model.response.CategoryResponse;
import com.csc.api.service.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@SecurityRequirement(name = "bearer")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping("/add")
    public ResponseEntity<CategoryResponse<Category>> addNewCategory(){

    }
}
