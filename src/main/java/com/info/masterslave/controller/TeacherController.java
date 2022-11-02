package com.info.masterslave.controller;

import com.info.masterslave.model.Teacher;
import com.info.masterslave.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.save(teacher));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.update(teacher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(teacherService.getAll());
    }
}
