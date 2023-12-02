package com.example.erpbackend.controller;

import com.example.erpbackend.model.alumni_organisations;
import com.example.erpbackend.model.placement;
import com.example.erpbackend.repository.alumni_orgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class alumni_orgController {
    @Autowired
    private alumni_orgRepository Alumni_orgRepository;

    @GetMapping("/alumni_org")
    List<alumni_organisations> getAlumniOrg() {
        return Alumni_orgRepository.findAll();
    }
}
