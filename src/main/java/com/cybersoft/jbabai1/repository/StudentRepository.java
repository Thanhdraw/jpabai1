package com.cybersoft.jbabai1.repository;

import com.cybersoft.jbabai1.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {


}
