package com.csc.api.repository;

import com.csc.api.model.request.CategoryRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.UUID;
@Mapper
public interface CategoryRepository {

    @Select("SELECT * FROM category WHERE delete_date IS NULL")
    UUID saveNewCategory(CategoryRequest request);
}
