package com.example.erpbackend.controller;

import com.example.erpbackend.model.placement_student;
import com.example.erpbackend.model.students;
import com.example.erpbackend.repository.placement_studentRepository;
import com.example.erpbackend.repository.studentsRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")   
public class studentController {
    @Autowired
    private studentsRepository studentsRepository;

    @GetMapping("/students")
    List<students> getAllStudents() {
        return studentsRepository.findAll();
    }
}
