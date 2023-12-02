package com.example.erpbackend.controller;

import com.example.erpbackend.model.alumni;
import com.example.erpbackend.model.alumni_organisations;
import com.example.erpbackend.repository.alumniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class alumniController {
    @Autowired
    private alumniRepository AlumniRepository;

    @GetMapping("/alumni")
    List<alumni> getAlumni() {
        return AlumniRepository.findAll();
    }
}
