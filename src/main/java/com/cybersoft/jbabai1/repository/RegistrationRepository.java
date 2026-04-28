package com.cybersoft.jbabai1.repository;

import com.cybersoft.jbabai1.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {

    List<Registration> findByStudentId(Long studentId);

    List<Registration> findByCourseId(Long courseId);

    boolean existsByStudent_IdAndCourse_Id(Long studentId, Long courseId);

    void deleteByStudent_IdAndCourse_Id(Long studentId, Long courseId);
}
