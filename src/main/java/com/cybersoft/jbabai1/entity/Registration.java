package com.cybersoft.jbabai1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
@Getter
@Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime registrationDate;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;




}
