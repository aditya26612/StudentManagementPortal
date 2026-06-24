package com.project.studentmanagementportal.repository;

import com.project.studentmanagementportal.constants.StudentStatus;
import com.project.studentmanagementportal.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Student> findByCourse(String course);

    List<Student> findByStatus(StudentStatus status);

    List<Student> findByNameContainingIgnoreCase(String keyword);

    Page<Student> findAll(Pageable pageable);
}