package com.info.masterslave.converter;

import com.info.masterslave.dto.StudentDto;
import com.info.masterslave.dto.TeacherDto;
import com.info.masterslave.model.Student;
import com.info.masterslave.model.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

    @Autowired
    ModelMapper modelMapper;

    public DtoConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Student convert(StudentDto dto){
        return modelMapper.map(dto, Student.class);
    }

    public StudentDto convert(Student entity){
        return modelMapper.map(entity, StudentDto.class);
    }

    public Teacher convert(TeacherDto dto){
        return modelMapper.map(dto, Teacher.class);
    }

    public TeacherDto convert(Teacher entity){
        return modelMapper.map(entity, TeacherDto.class);
    }

}
