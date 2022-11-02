package com.info.masterslave.repository.writeRepository;

import com.info.masterslave.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentWriteRepository extends JpaRepository<Student, Long> {
}
