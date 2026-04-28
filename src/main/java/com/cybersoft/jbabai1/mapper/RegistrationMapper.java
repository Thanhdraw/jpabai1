package com.cybersoft.jbabai1.mapper;

import com.cybersoft.jbabai1.dto.response.RegistrationResponse;
import com.cybersoft.jbabai1.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

    @Autowired
    private CourseMapper courseMapper;

    public RegistrationResponse toResponse(Registration registration) {
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setId(registration.getId());
        registrationResponse.setRegistrationDate(registration.getRegistrationDate());
        registrationResponse.setCourse(courseMapper.toResponse(registration.getCourse()));
        return registrationResponse;
    }
}
