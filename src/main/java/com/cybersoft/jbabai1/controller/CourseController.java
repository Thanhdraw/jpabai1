package com.cybersoft.jbabai1.controller;

import com.cybersoft.jbabai1.dto.response.CourseResponse;
import com.cybersoft.jbabai1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping
    public ResponseEntity<List<CourseResponse>> getCourses(@RequestParam(required = false) Integer durationGreaterThan) {
        return ResponseEntity.ok(courseService.getCoursesByDuration(durationGreaterThan));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCourseCount() {
        return ResponseEntity.ok(courseService.countCourses());
    }
}
