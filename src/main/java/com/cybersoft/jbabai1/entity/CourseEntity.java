package com.cybersoft.jbabai1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @Column(nullable = true)
    private Integer duration;


    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Registration> registrations;


}
