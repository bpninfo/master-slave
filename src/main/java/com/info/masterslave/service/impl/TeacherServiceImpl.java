package com.info.masterslave.service.impl;

import com.info.masterslave.model.Teacher;
import com.info.masterslave.repository.readRepository.TeacherReadRepository;
import com.info.masterslave.repository.writeRepository.TeacherWriteRepository;
import com.info.masterslave.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherReadRepository teacherReadRepository;
    private final TeacherWriteRepository teacherWriteRepository;

    public TeacherServiceImpl(TeacherReadRepository teacherReadRepository, TeacherWriteRepository teacherWriteRepository){
        this.teacherReadRepository = teacherReadRepository;
        this.teacherWriteRepository = teacherWriteRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherWriteRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher getById(Long id) {
        return teacherReadRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Teacher> getAll() {
        return teacherReadRepository.findAll();
    }
}
