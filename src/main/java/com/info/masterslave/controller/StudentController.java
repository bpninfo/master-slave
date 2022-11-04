package com.info.masterslave.controller;

import com.info.masterslave.dto.StudentDto;
import com.info.masterslave.model.Student;
import com.info.masterslave.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody StudentDto student){
        return ResponseEntity.ok(studentService.update(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/by/mapper/{id}")
    public ResponseEntity<?> getStudentByMapper(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentByMapper(id));
    }
}
