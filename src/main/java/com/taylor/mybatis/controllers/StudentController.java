/*
 * File: src\main\java\com\taylor\mybatis\controllers\StudentController.java
 * Project: jpa
 * Created Date: Friday, November 3rd 2023, 8:15:47 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Friday, 3rd November 2023 9:39:22 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Friday, November 3rd 2023	Rui Yu		Initial version
 */

package com.taylor.mybatis.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taylor.mybatis.Services.StudentService;
import com.taylor.mybatis.models.Student;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final com.taylor.mybatis.Services.StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Get all students
    @GetMapping()
    public List<Student> getAll(@RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size) {
        return service.getAll(page, size);
    }

    // Create a new student
    @PostMapping()
    public Student create(@RequestBody Student student) {
        long id = service.create(student);

        return service.getById(id);
    }

    // Get student by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Get student by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getById(@PathVariable String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    // Update student score
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateScore(@PathVariable Long id, @RequestBody Student studentDetails) {
        service.updateScore(id, studentDetails.getScore());

        return ResponseEntity.ok(service.getById(id));
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {
        service.delete(id);

        Map<String, Object> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}