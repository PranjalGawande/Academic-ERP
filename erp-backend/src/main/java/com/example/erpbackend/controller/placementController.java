package com.example.erpbackend.controller;

import com.example.erpbackend.model.placement;
import com.example.erpbackend.model.students;
import com.example.erpbackend.repository.placementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class placementController {
    @Autowired
    private placementRepository PlacementRepository;

    @GetMapping("/placement")
    List<placement> getPlacement() {
        return PlacementRepository.findAll();
    }
}
