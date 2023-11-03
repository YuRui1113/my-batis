/*
 * File: src\main\java\com\taylor\mybatis\Services\StudentSerevice.java
 * Project: jpa
 * Created Date: Friday, November 3rd 2023, 8:23:29 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Friday, 3rd November 2023 9:39:09 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Friday, November 3rd 2023	Rui Yu		Initial version
 */

package com.taylor.mybatis.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taylor.mybatis.mappers.StudentMapper;
import com.taylor.mybatis.models.Student;

@Service
public class StudentService {

    private final StudentMapper mapper;

    public StudentService(StudentMapper mapper) {
        this.mapper = mapper;
    }

    public List<Student> getAll(Optional<Integer> page, Optional<Integer> size) {
        if (page.isEmpty() || size.isEmpty()) {
            return mapper.findAll();
        } else {
            return mapper.findByPage(page.get(), size.get());
        }
    }

    public Student getById(long id) {
        return mapper.findById(id);
    }

    public List<Student> getByName(String name) {
        return mapper.findByName(name);
    }

    public Long create(Student student) {
        mapper.add(student);

        return student.getId();
    }

    public Integer updateScore(Long id, Integer score) {
        return mapper.updateScore(id, score);
    }

    public int delete(Long id) {
        return mapper.delete(id);
    }
}