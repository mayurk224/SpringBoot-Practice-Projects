package com.springproject.sms.service;

import com.springproject.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudent(Long studentId);
}
