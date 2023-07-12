package com.csc.api.repository;

import com.csc.api.model.entity.SuperCategory;
import com.csc.api.model.request.SuperCategoryRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface SuperCategoryRepository {

    @Results(
            id = "superCategoryMapper",
            value = {
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "updated_date"),
                    @Result(property = "deleteDate", column = "delete_date")
            }

    )
    @Select("""
            SELECT * FROM super_categories WHERE delete_date IS NULL
            """)
    List<SuperCategory> findAllCategory();

    @Select("INSERT INTO super_categories (name) VALUES (#{request.name}) returning id")
    UUID saveNewSuper(@Param("request") SuperCategoryRequest superCategoryRequest);

    @ResultMap("superCategoryMapper")
    @Select("""
            SELECT * FROM super_categories WHERE id =#{categoryId} AND delete_date is null
            """)
    SuperCategory findSuperCategoryById(UUID categoryId);

    @ResultMap("superCategoryMapper")
    @Select("""
            UPDATE super_categories
            set delete_date = CURRENT_TIMESTAMP WHERE id = #{categoryId} AND delete_date IS NULL
            RETURNING *
            """)
    SuperCategory deleteSuperCategoryId(UUID categoryId);



    @Select("""
            UPDATE super_categories
            set updated_date = CURRENT_TIMESTAMP ,name = #{request.name}
            WHERE id =  #{categoryId} AND delete_date is NULL
            """)
    @ResultMap("superCategoryMapper")
    SuperCategory updatedCategoryById( UUID categoryId,@Param("request") SuperCategoryRequest categoryRequest);

}
