package com.info.masterslave.mapper;

import com.info.masterslave.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentMapper {

    @Select("select * from student where id = #{id}")
    Student getStudenta(@Param("id") Long id);

}
