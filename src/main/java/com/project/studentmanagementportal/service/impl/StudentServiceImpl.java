package com.project.studentmanagementportal.service.impl;

import com.project.studentmanagementportal.constants.AppConstants;
import com.project.studentmanagementportal.dto.request.UpdateStudentRequest;
import com.project.studentmanagementportal.dto.response.StudentResponse;
import com.project.studentmanagementportal.entity.Student;
import com.project.studentmanagementportal.exception.StudentNotFoundException;
import com.project.studentmanagementportal.mapper.StudentMapper;
import com.project.studentmanagementportal.repository.StudentRepository;
import com.project.studentmanagementportal.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse getStudentById(Long studentId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow(() ->
                                new StudentNotFoundException(
                                        AppConstants.STUDENT_NOT_FOUND
                                ));

        return studentMapper.toResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Override
    public StudentResponse updateStudent(
            Long studentId,
            UpdateStudentRequest request
    ) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow(() ->
                                new StudentNotFoundException(
                                        AppConstants.STUDENT_NOT_FOUND
                                ));

        studentMapper.updateEntity(request, student);

        Student updatedStudent =
                studentRepository.save(student);

        log.info("Student updated: {}", updatedStudent.getId());

        return studentMapper.toResponse(updatedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow(() ->
                                new StudentNotFoundException(
                                        AppConstants.STUDENT_NOT_FOUND
                                ));

        studentRepository.delete(student);

        log.info("Student deleted: {}", studentId);
    }

    @Override
    public List<StudentResponse> searchStudents(
            String keyword
    ) {

        return studentRepository
                .findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Override
    public Page<StudentResponse> getStudents(
            int page,
            int size
    ) {

        return studentRepository
                .findAll(PageRequest.of(page, size))
                .map(studentMapper::toResponse);
    }


}

