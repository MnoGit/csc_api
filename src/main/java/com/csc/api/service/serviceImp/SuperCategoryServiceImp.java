package com.csc.api.service.serviceImp;
import com.csc.api.model.entity.SuperCategory;
import com.csc.api.model.request.SuperCategoryRequest;
import com.csc.api.repository.SuperCategoryRepository;
import com.csc.api.service.SuperCategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SuperCategoryServiceImp implements SuperCategoryService {

private final SuperCategoryRepository superCategoryRepository;
    @Override
    public UUID addNewSuper(SuperCategoryRequest superCategoryRequest) {
        UUID addNewSuperCategory = superCategoryRepository.saveNewSuper(superCategoryRequest);
        return addNewSuperCategory;

    }

    @Override
    public List<SuperCategory> getAllSuper() {
        return superCategoryRepository.findAllCategory();
    }

    @Override
    public SuperCategory getSuperCategoryById(UUID categoryId) {
        return superCategoryRepository.findSuperCategoryById(categoryId);
    }

    @Override
    public SuperCategory deleteSuperCategoryId(UUID categoryId) {
        return superCategoryRepository.deleteSuperCategoryId(categoryId);
    }

    @Override
    public SuperCategory updateSuperCategory(UUID categoryId, SuperCategoryRequest categoryRequest) {
        return superCategoryRepository.updatedCategoryById(categoryId,categoryRequest);
    }
//
//    @Override
//    public SuperCategory deleteSuperCategoryId(UUID categoryId) {
//
//        return superCategoryRepository.deleteSuperCategoryId(categoryId);
//
//    }


}
