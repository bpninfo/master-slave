package com.info.masterslave.service.impl;

import com.info.masterslave.converter.DtoConverter;
import com.info.masterslave.dto.TeacherDto;
import com.info.masterslave.model.Teacher;
import com.info.masterslave.repository.readRepository.TeacherReadRepository;
import com.info.masterslave.repository.writeRepository.TeacherWriteRepository;
import com.info.masterslave.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherReadRepository teacherReadRepository;
    private final TeacherWriteRepository teacherWriteRepository;
    private final DtoConverter dtoConverter;

    public TeacherServiceImpl(TeacherReadRepository teacherReadRepository,
                              TeacherWriteRepository teacherWriteRepository,
                              DtoConverter dtoConverter) {
        this.teacherReadRepository = teacherReadRepository;
        this.teacherWriteRepository = teacherWriteRepository;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public TeacherDto save(TeacherDto teacher) {
        log.info("write");
        log.info("-------------------: 192.168.50.117:5000");
        return dtoConverter.convert(teacherWriteRepository.save(dtoConverter.convert(teacher)));
    }

    @Override
    public TeacherDto update(Long id, TeacherDto teacher) {
        log.info("write");
        log.info("-------------------: 192.168.50.117:5000");
        Teacher entity = teacherWriteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (teacher.getName() != null)
            entity.setName(teacher.getName());
        return dtoConverter.convert(teacherWriteRepository.save(entity));
    }

    @Override
    public TeacherDto getById(Long id) {
        log.info("read");
        log.info("-------------------: 192.168.50.117:5001");
        return dtoConverter.convert(teacherReadRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<TeacherDto> getAll() {
        log.info("read");
        log.info("-------------------: 192.168.50.117:5001");
        return teacherReadRepository.findAll().stream().map(dtoConverter::convert).collect(Collectors.toList());
    }
}
