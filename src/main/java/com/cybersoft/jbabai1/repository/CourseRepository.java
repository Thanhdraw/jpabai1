package com.cybersoft.jbabai1.repository;

import com.cybersoft.jbabai1.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

    @Query("select c from CourseEntity c where c.duration > :hours")
    List<CourseEntity> findCoursesWithDurationGreaterThan(@Param("hours") int hours);

    @Query("select COUNT(c) from CourseEntity c")
    long countCourse();
}
