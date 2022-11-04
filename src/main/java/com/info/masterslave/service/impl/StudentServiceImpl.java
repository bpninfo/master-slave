package com.info.masterslave.service.impl;

import com.info.masterslave.converter.DtoConverter;
import com.info.masterslave.dto.StudentDto;
import com.info.masterslave.mapper.StudentMapper;
import com.info.masterslave.model.Student;
import com.info.masterslave.repository.readRepository.StudentReadRepository;
import com.info.masterslave.repository.writeRepository.StudentWriteRepository;
import com.info.masterslave.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentReadRepository studentReadRepository;
    private final StudentWriteRepository studentWriteRepository;
    private final DtoConverter dtoConverter;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentReadRepository studentReadRepository,
                              StudentWriteRepository studentWriteRepository,
                              DtoConverter dtoConverter,
                              StudentMapper studentMapper) {
        this.studentReadRepository = studentReadRepository;
        this.studentWriteRepository = studentWriteRepository;
        this.dtoConverter = dtoConverter;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto save(StudentDto student) {
        return dtoConverter.convert(studentWriteRepository.save(dtoConverter.convert(student)));
    }

    @Override
    public StudentDto update(StudentDto student) {
        return null;
    }

    @Override
    public StudentDto getById(Long id) {
        return dtoConverter.convert(studentReadRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> list = studentReadRepository.findAll();
        return list.stream().map(dtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public Student getStudentByMapper(Long id) {
        return studentMapper.getStudenta(id);
    }
}
