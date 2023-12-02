package com.example.erpbackend.repository;

import com.example.erpbackend.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<employee, Integer> {
    employee findByEmailAndPassword(String email, String password);
}
