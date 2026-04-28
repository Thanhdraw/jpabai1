package com.cybersoft.jbabai1.repository;

import com.cybersoft.jbabai1.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    @Query("select s from StudentEntity s where lower(s.name) like lower(concat('%',:keyword, '%') ) ")
    List<StudentEntity> searchByName(@Param("keyword") String keyword);
}
