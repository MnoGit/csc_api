package com.csc.api.repository;

import com.csc.api.model.entity.UserInfo;
import com.csc.api.model.request.UserRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM users WHERE name = #{name}")
    UserInfo getUserByUserName(@Param("name") String name );

    @Select("INSERT INTO users (name, password, email, role) VALUES (#{info.name}, #{info.password}, #{info.email}, #{info.role}) RETURNING *")
    Integer saveUser(@Param("info") UserRequest userRequest);
    @Select("SELECT * FROM users")
    List<UserInfo> findAllUser();

    @Select("SELECT * FROM users WHERE name = #{name}")
    UserInfo findByEmail(@Param("name") String name);
}
