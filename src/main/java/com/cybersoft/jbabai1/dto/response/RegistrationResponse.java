package com.cybersoft.jbabai1.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegistrationResponse {

    private Long id;
    private LocalDateTime registrationDate;
    private CourseResponse course;
}
