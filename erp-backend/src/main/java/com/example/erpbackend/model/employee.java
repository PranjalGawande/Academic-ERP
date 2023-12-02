package com.example.erpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id", nullable = false, unique = true)
    private Integer employee_id;

    @Column(name="first_name", nullable = false)
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="title")
    private String title;

    @Column(name = "photograph_path")
    private String photograph_path;

    @Column(name="department")
    private String department;

    @Column(name="password")
    private String password;

}
