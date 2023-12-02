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
@Table(name = "placement_student")
public class placement_student {
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="placement_id")
    private placement placement_id;

    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private students student_id;

    @Column(name="acceptance")
    private String acceptance;

    @Column(name="date")
    private String date;

}
