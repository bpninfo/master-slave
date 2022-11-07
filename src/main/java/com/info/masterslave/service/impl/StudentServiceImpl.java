package com.info.masterslave.service.impl;

import com.info.masterslave.converter.DtoConverter;
import com.info.masterslave.dto.StudentDto;
import com.info.masterslave.mapper.StudentMapper;
import com.info.masterslave.model.Student;
import com.info.masterslave.repository.readRepository.StudentReadRepository;
import com.info.masterslave.repository.writeRepository.StudentWriteRepository;
import com.info.masterslave.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
        log.info("write");
        log.info("-------------------: 192.168.50.117:5000");
        return dtoConverter.convert(studentWriteRepository.save(dtoConverter.convert(student)));
    }

    @Override
    public StudentDto update(Long id, StudentDto student) {
        log.info("write");
        log.info("-------------------: 192.168.50.117:5000");
        Student entity = studentWriteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (student.getName() != null)
            entity.setName(student.getName());
        return dtoConverter.convert(studentWriteRepository.save(entity));
    }

    @Override
    public StudentDto getById(Long id) {
        log.info("read");
        log.info("-------------------: 192.168.50.117:5001");
        return dtoConverter.convert(studentReadRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<StudentDto> getAll() {
        log.info("read");
        log.info("-------------------: 192.168.50.117:5001");
        List<Student> list = studentReadRepository.findAll();
        return list.stream().map(dtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public Student getStudentByMapper(Long id) {
        log.info("read");
        log.info("-------------------: 192.168.50.117:5001");
        return studentMapper.getStudenta(id);
    }
}
