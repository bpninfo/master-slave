package com.info.masterslave.repository.writeRepository;

import com.info.masterslave.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherWriteRepository extends JpaRepository<Teacher, Long> {
}
