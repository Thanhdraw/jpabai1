package com.cybersoft.jbabai1.controller;

import com.cybersoft.jbabai1.dto.request.RegisterCourseRequest;
import com.cybersoft.jbabai1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService  registerService;


    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<?> registerCourses(
            @PathVariable Long studentId,
            @RequestBody RegisterCourseRequest request) {

        registerService.registerCourses(studentId, request);
        return ResponseEntity.ok("Register success");
    }
    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<?> getCourses(@PathVariable Long studentId) {
        return ResponseEntity.ok(registerService.getCoursesByStudent(studentId));
    }

    @GetMapping("/courses/{courseId}/students")
    public ResponseEntity<?> getStudents(@PathVariable Long courseId) {
        return ResponseEntity.ok(registerService.getStudentsByCourse(courseId));
    }

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<?> addCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        registerService.addCourseToStudent(studentId, courseId);
        return ResponseEntity.ok("Registered");
    }

    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<?> removeCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        registerService.removeCourseFromStudent(studentId, courseId);
        return ResponseEntity.ok("Removed");
    }

}
