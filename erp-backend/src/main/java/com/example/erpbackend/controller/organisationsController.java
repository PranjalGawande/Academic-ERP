package com.example.erpbackend.controller;

import com.example.erpbackend.model.organisations;
import com.example.erpbackend.model.placement;
import com.example.erpbackend.repository.organisationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class organisationsController {
    @Autowired
    private organisationsRepository OrgnisationsRepostiory;

    @GetMapping("/organisations")
    List<organisations> getOrganisations() {
        return OrgnisationsRepostiory.findAll();
    }

}
