package com.info.masterslave.service;


import com.info.masterslave.model.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    Student update(Student student);

    Student getById(Long id);

    List<Student> getAll();

}
