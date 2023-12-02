package com.example.erpbackend.controller;

import com.example.erpbackend.exception.ForbiddenException;
import com.example.erpbackend.exception.UnauthorizedException;
import com.example.erpbackend.model.employee;
import com.example.erpbackend.model.placement;
import com.example.erpbackend.model.students;
import com.example.erpbackend.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("http://localhost:3000")
public class employeeController {
    @Autowired
    private employeeRepository EmployeeRepository;

    @PostMapping("/login")
    public ResponseEntity<employee>login(@RequestBody employee Employee) {
        employee loggedInEmployee = EmployeeRepository.findByEmailAndPassword(Employee.getEmail(), Employee.getPassword());

        if (loggedInEmployee == null) {
            throw new UnauthorizedException("Unauthorized access!");
        } else if (!Objects.equals(loggedInEmployee.getDepartment(), "Outreach")) {
            throw new ForbiddenException("Access to this resource is forbidden!");
        } else {
            return ResponseEntity.ok().body(loggedInEmployee);
        }
    }

    @GetMapping("/employee")
    List<employee> getEmployee() {
        return EmployeeRepository.findAll();
    }
}
