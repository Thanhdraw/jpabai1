package com.cybersoft.jbabai1.mapper;


import com.cybersoft.jbabai1.dto.response.CourseResponse;
import com.cybersoft.jbabai1.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseResponse toResponse(CourseEntity courseEntity) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(courseEntity.getId());
        courseResponse.setTitle(courseEntity.getTitle());
        return courseResponse;
    }
}
