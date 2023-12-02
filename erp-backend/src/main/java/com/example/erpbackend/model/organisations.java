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
@Table(name = "organisations")
public class organisations {
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "organisation_id")
    private List<placement> placement = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "organisation_id")
    private List<alumni_organisations> alumni_organisations = new ArrayList<>();

}
