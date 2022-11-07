package com.info.masterslave.service;


import com.info.masterslave.dto.TeacherDto;
import com.info.masterslave.model.Teacher;

import java.util.List;

public interface TeacherService {

    TeacherDto save(TeacherDto teacher);

    TeacherDto update(Long id, TeacherDto teacher);

    TeacherDto getById(Long id);

    List<TeacherDto> getAll();
}
