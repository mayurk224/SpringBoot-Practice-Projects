package com.springproject.sms.service;

import com.springproject.sms.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudent(Long studentId);

    void updateStudent(@Valid StudentDto studentDto);

    void deleteStudent(Long studentId);

    StudentDto getStudentById(Long studentId);
}
