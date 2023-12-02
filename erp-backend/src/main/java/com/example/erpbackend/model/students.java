package com.example.erpbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class students {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="roll_number", nullable = false, unique = true)
    private String roll_number;

    @Column(name="first_name", nullable = false)
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name = "photograph_path")
    private String photograph_path;

    @Column(name = "cgpa")
    private Float cgpa;

    @Column(name = "total_credits")
    private Float total_credits;

    @Column(name = "graduation_year")
    private Integer graduation_year;

    @Column(name = "domain")
    private String domain;

    @Column(name = "specialisation")
    private String specialisation;

    @ManyToOne
    @JoinColumn(name = "placement_id")
    private placement placement_id;

    @JsonIgnore
    @OneToMany(mappedBy = "student_id")
    private List<placement_student> placementStudents = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "student_id")
    private List<alumni> alumni = new ArrayList<>();

}
