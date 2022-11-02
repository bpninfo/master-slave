package com.info.masterslave.service.impl;

import com.info.masterslave.model.Student;
import com.info.masterslave.repository.readRepository.StudentReadRepository;
import com.info.masterslave.repository.writeRepository.StudentWriteRepository;
import com.info.masterslave.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentReadRepository studentReadRepository;
    private final StudentWriteRepository studentWriteRepository;

    public StudentServiceImpl(StudentReadRepository studentReadRepository, StudentWriteRepository studentWriteRepository){
        this.studentReadRepository = studentReadRepository;
        this.studentWriteRepository = studentWriteRepository;
    }

    @Override
    public Student save(Student student) {
        return studentWriteRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return studentReadRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Student> getAll() {
        return studentReadRepository.findAll();
    }
}
