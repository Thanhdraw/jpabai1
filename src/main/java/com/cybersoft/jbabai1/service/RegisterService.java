package com.cybersoft.jbabai1.service;


import com.cybersoft.jbabai1.dto.request.RegisterCourseRequest;
import com.cybersoft.jbabai1.dto.response.CourseResponse;
import com.cybersoft.jbabai1.dto.response.StudentResponse;
import com.cybersoft.jbabai1.entity.CourseEntity;
import com.cybersoft.jbabai1.entity.Registration;
import com.cybersoft.jbabai1.entity.StudentEntity;
import com.cybersoft.jbabai1.mapper.CourseMapper;
import com.cybersoft.jbabai1.mapper.StudentMapper;
import com.cybersoft.jbabai1.repository.CourseRepository;
import com.cybersoft.jbabai1.repository.RegistrationRepository;
import com.cybersoft.jbabai1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final RegistrationRepository registrationRepository;

    private final CourseMapper courseMapper;

    private final StudentMapper studentMapper;


    public void registerCourses(Long studentId, RegisterCourseRequest request) {


        System.out.println(">>> START");

        System.out.println("StudentId: " + studentId);
        System.out.println("Request: " + request);

        if (request.getCourseIds() == null) {
            throw new RuntimeException("courseIds is NULL");
        }

        System.out.println("CourseIds: " + request.getCourseIds());


        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        System.out.println("Student OK");

        List<CourseEntity> courses = courseRepository.findAllById(request.getCourseIds());
        System.out.println("Courses size: " + courses.size());
        System.out.println(">>> AFTER GET COURSES");
        if (courses.size() != request.getCourseIds().size()) {
            throw new RuntimeException("Course not found");
        }
        System.out.println("Courses size: " + courses.size());

        List<Registration> registrations = new ArrayList<>();

        for (CourseEntity course : courses) {
            Registration r = new Registration();
            r.setStudent(student);
            r.setCourse(course);
            r.setRegistrationDate(LocalDateTime.now());
            registrations.add(r);
        }

        registrationRepository.saveAll(registrations);
    }

    public List<CourseResponse> getCoursesByStudent(Long studentId) {

        studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));


        List<Registration> registrations =
                registrationRepository.findByStudentId(studentId);

        return registrationRepository.findByStudentId(studentId)
                .stream()
                .map(Registration::getCourse)
                .map(courseMapper::toResponse)
                .toList();
    }

    public List<StudentResponse> getStudentsByCourse(Long courseId) {
        return registrationRepository.findByCourseId(courseId)
                .stream()
                .map(Registration::getStudent)
                .map(studentMapper::toResponse)
                .toList();
    }

    @Transactional
    public void addCourseToStudent(Long studentId, Long courseId) {
        StudentEntity  student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        CourseEntity course =  courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if(registrationRepository.existsByStudent_IdAndCourse_Id(studentId, courseId))
        {
            throw new RuntimeException("Student already exists");
        }
        Registration registration = new Registration();
        registration.setStudent(student);
        registration.setCourse(course);
        registration.setRegistrationDate(LocalDateTime.now());
        registrationRepository.save(registration);
    }

    @Transactional
    public void removeCourseFromStudent(Long studentId, Long courseId) {
        if(!registrationRepository.existsByStudent_IdAndCourse_Id(studentId, courseId)){
            throw new RuntimeException("Registertration not found");
        }
        registrationRepository.deleteByStudent_IdAndCourse_Id(studentId, courseId);
    }

}
