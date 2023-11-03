/*
 * File: src\main\java\com\taylor\mybatis\mappers\StudentMapper.java
 * Project: jpa
 * Created Date: Friday, November 3rd 2023, 7:51:50 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Friday, 3rd November 2023 9:39:14 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Friday, November 3rd 2023	Rui Yu		Initial version
 */

package com.taylor.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.taylor.mybatis.models.Student;
import com.taylor.mybatis.utils.SQLBuilder;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students")
    List<Student> findAll();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student findById(@Param("id") Long id);

    @Insert("INSERT INTO students(name, sex, age, description) " +
            "VALUES (#{name}, #{sex}, #{age}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(Student item);

    @Delete("DELETE FROM students WHERE id = #{id}")
    int delete(@Param("id") Long id);

    @Update("Update students set score=#{score} where id=#{id}")
    int updateScore(@Param("id") Long id, @Param("score") Integer score);

    @SelectProvider(type = SQLBuilder.class, method = "getStudentsByName")
    public List<Student> findByName(String name);

    @SelectProvider(type = SQLBuilder.class, method = "getStudentsForPage")
    List<Student> findByPage(int page, int size);
}