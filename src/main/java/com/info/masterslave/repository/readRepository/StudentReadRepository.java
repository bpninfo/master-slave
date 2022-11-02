package com.info.masterslave.repository.readRepository;


import com.info.masterslave.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReadRepository extends JpaRepository<Student, Long> {

}
