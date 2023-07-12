package com.csc.api.service;

import com.csc.api.model.request.CategoryRequest;

import java.util.UUID;

public interface CategoryService {
    UUID addNewCategory (CategoryRequest request);

}
