package com.info.masterslave.repository.readRepository;


import com.info.masterslave.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherReadRepository extends JpaRepository<Teacher, Long> {
}
