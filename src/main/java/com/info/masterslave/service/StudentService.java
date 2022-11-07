package com.info.masterslave.service;


import com.info.masterslave.dto.StudentDto;
import com.info.masterslave.model.Student;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentDto student);

    StudentDto update(Long id, StudentDto student);

    StudentDto getById(Long id);

    List<StudentDto> getAll();

    Student getStudentByMapper(Long id);

}
