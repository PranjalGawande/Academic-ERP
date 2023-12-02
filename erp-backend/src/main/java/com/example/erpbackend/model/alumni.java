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
@Table(name = "alumni")
public class alumni {
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="contact_number", nullable = false, unique = true)
    private String contact_number;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private students student_id;

    @JsonIgnore
    @OneToMany(mappedBy = "alumni_id")
    private List<alumni_organisations> alumni_organisations = new ArrayList<>();

}
