package com.csc.api.repository;

import com.csc.api.model.entity.Author;
import com.csc.api.model.request.AuthorRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorRepository {
    @Select("SELECT * FROM authors")
    List<Author> findAllAuthor();
    @Select("INSERT INTO authors (name, email) VALUES (#{request.name}, #{request.email})")
    Integer saveAuthor(@Param("request") AuthorRequest authorRequest);

}
