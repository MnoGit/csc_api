package com.csc.api.service.serviceImp;

import com.csc.api.model.request.CategoryRequest;
import com.csc.api.repository.CategoryRepository;
import com.csc.api.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public UUID addNewCategory(CategoryRequest request) {
        return repository.saveNewCategory(request);
    }
}
