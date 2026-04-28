package com.cybersoft.jbabai1.service;

import com.cybersoft.jbabai1.dto.request.CreateStudentRequest;
import com.cybersoft.jbabai1.dto.request.UpdateStudentRequest;
import com.cybersoft.jbabai1.dto.response.StudentResponse;
import com.cybersoft.jbabai1.entity.StudentEntity;
import com.cybersoft.jbabai1.exception.NotFoundStudentException;
import com.cybersoft.jbabai1.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream().map(studentEntity -> {
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setId(studentEntity.getId());
            studentResponse.setName(studentEntity.getName());
            studentResponse.setEmail(studentEntity.getEmail());
            studentResponse.setAge(studentEntity.getAge());
            return studentResponse;
        }).toList();
    }

    public StudentResponse addStudent(CreateStudentRequest createStudentRequest) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(createStudentRequest.getName());
        studentEntity.setEmail(createStudentRequest.getEmail());
        studentEntity.setAge(createStudentRequest.getAge());
        studentRepository.save(studentEntity);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setEmail(studentEntity.getEmail());
        studentResponse.setAge(studentEntity.getAge());
        return studentResponse;
    }


    public StudentResponse updateStudentById(@RequestParam Long id, @Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new NotFoundStudentException("Student not found"));
        studentEntity.setName(updateStudentRequest.getName());
        studentEntity.setEmail(updateStudentRequest.getEmail());
        studentEntity.setAge(updateStudentRequest.getAge());
        studentRepository.save(studentEntity);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setEmail(studentEntity.getEmail());
        studentResponse.setAge(studentEntity.getAge());
        return studentResponse;
    }

    public StudentResponse findStudentById(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new NotFoundStudentException("Student not found"));
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setEmail(studentEntity.getEmail());
        studentResponse.setAge(studentEntity.getAge());
        return studentResponse;
    }


    public List<StudentResponse> searchStudent(String keyword) {
        List<StudentEntity> students = studentRepository.searchByName(keyword);

        return students.stream()
                .map(s -> new StudentResponse(
                        s.getId(),
                        s.getName(),
                        s.getEmail(),
                        s.getAge()
                ))
                .collect(Collectors.toList());
    }


    public void deleteStudentById(@RequestParam Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new NotFoundStudentException("Student not found"));
        studentRepository.delete(studentEntity);
    }


}
