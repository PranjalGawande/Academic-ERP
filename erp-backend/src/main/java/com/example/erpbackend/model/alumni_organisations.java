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
@Table(name = "alumni_organisations")
public class alumni_organisations {
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="organisation_id")
    private organisations organisation_id;

    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private alumni alumni_id;

    @Column(name="position")
    private String position;

    @Column(name="joining_date", nullable = false)
    private String joining_date;

    @Column(name="leaving_date", nullable = false)
    private String leaving_date;
}
