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
@Table(name = "placement")
public class placement {
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="organisation_id")
    private organisations organisation_id;

    @Column(name="profile",nullable = false)
    private String profile;

    @Column(name="description")
    private String description;

    @Column(name="intake", nullable = false)
    private Integer intake;

    @Column(name="minimum_grade")
    private Double minimum_grade;

    @JsonIgnore
    @OneToMany(mappedBy = "placement_id")
    private List<students> students = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "placement_id")
    private List<placement_student> placementStudents = new ArrayList<>();

}
