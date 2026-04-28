package com.cybersoft.jbabai1.controller;


import com.cybersoft.jbabai1.dto.request.CreateStudentRequest;
import com.cybersoft.jbabai1.dto.request.UpdateStudentRequest;
import com.cybersoft.jbabai1.dto.response.StudentResponse;
import com.cybersoft.jbabai1.exception.APIResponse;
import com.cybersoft.jbabai1.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(createStudentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentById(@Valid @RequestBody UpdateStudentRequest updateStudentRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentById(id, updateStudentRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@RequestParam Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/test-no-agrs")
    public ResponseEntity<?> testNoAgrs(@RequestBody APIResponse<String> apiResponse) {
        return ResponseEntity.ok("Du lieu nhan được: "+apiResponse.getMessage());
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String name) {
        return ResponseEntity.ok(studentService.searchStudent(name));
    }


}
