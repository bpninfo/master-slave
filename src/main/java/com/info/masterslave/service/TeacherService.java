package com.info.masterslave.service;


import com.info.masterslave.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher);

    Teacher getById(Long id);

    List<Teacher> getAll();
}
