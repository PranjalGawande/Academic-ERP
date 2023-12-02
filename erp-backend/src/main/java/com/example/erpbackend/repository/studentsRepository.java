package com.example.erpbackend.repository;

import com.example.erpbackend.model.students;
import com.example.erpbackend.model.placement_student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface studentsRepository extends JpaRepository<students, Integer> {


}
