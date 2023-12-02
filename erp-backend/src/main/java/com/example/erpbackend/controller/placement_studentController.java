package com.example.erpbackend.controller;

import com.example.erpbackend.model.placement;
import com.example.erpbackend.model.placement_student;
import com.example.erpbackend.repository.placement_studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class placement_studentController {
    @Autowired
    private placement_studentRepository PlacementStudentRepository;

    @GetMapping("/placement_student")
    List<placement_student> getPlacementStudent() {
        return PlacementStudentRepository.findAll();
    }
}
