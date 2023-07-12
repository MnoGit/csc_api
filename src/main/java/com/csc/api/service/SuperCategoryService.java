package com.csc.api.service;

import com.csc.api.model.entity.SuperCategory;
import com.csc.api.model.request.SuperCategoryRequest;

import java.util.List;
import java.util.UUID;

public interface SuperCategoryService {

    UUID addNewSuper(SuperCategoryRequest superCategoryRequest);
    List<SuperCategory> getAllSuper();
    SuperCategory getSuperCategoryById(UUID categoryId);
    SuperCategory deleteSuperCategoryId(UUID categoryId);
    SuperCategory updateSuperCategory(UUID categoryId, SuperCategoryRequest superCategoryRequest);

}
