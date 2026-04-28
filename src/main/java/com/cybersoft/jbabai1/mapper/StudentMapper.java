package com.cybersoft.jbabai1.mapper;

import com.cybersoft.jbabai1.dto.response.StudentResponse;
import com.cybersoft.jbabai1.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponse toResponse(StudentEntity studentEntity) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setEmail(studentEntity.getEmail());
        studentResponse.setAge(studentEntity.getAge());
        return studentResponse;
    }
}
