package com.lab.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.exercise.entities.Student;
import com.lab.exercise.services.StudentService;

@RestController
@RequestMapping("/api/modules")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all modules
    @GetMapping
    public List<String> getAllModules() {
        return studentService.getAllModules();
    }

    // Get students for a module
    @GetMapping("/{module}")
    public List<Student> getStudentsByModule(@PathVariable String module) {
        return studentService.getStudentsByModule(module);
    }

    // Get all students for a module
    @GetMapping("/{module}/students/all")
    public List<Student> getAllStudentsByModule(@PathVariable String module) {
        return studentService.getAllStudentsByModule(module);
    }

    // Get student by id for a module
    @GetMapping("/{module}/students/{id}")
    public Student getStudentById(@PathVariable String module, @PathVariable Long id) {
        return studentService.getStudentById(module, id);
    }

    // Create a new student for a module
    @PostMapping("/{module}/students")
    public Student createStudent(@PathVariable String module, @RequestBody Student student) {
        return studentService.createStudent(module, student);
    }

    // Update a student for a module
    @PutMapping("/{module}/students/{id}")
    public Student updateStudent(@PathVariable String module, @PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(module, id, student);
    }

    // Delete a student for a module
    @DeleteMapping("/{module}/students/{id}")
    public void deleteStudent(@PathVariable String module, @PathVariable Long id) {
        studentService.deleteStudent(module, id);
    }
}