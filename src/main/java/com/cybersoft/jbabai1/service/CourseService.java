package com.cybersoft.jbabai1.service;


import com.cybersoft.jbabai1.dto.response.CourseResponse;
import com.cybersoft.jbabai1.entity.CourseEntity;
import com.cybersoft.jbabai1.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    public List<CourseResponse> getCoursesByDuration(Integer hours) {
        List<CourseEntity> courses;

        if (hours != null) {
            courses = courseRepository.findCoursesWithDurationGreaterThan(hours);
        } else {
            courses = courseRepository.findAll();
        }

        return courses.stream()
                .map(c -> new CourseResponse(
                        c.getId(),
                        c.getTitle(),
                        c.getDuration()
                ))
                .collect(Collectors.toList());
    }

    public long countCourses() {
        return courseRepository.countCourse();
    }
}
