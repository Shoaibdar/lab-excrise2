package com.lab.exercise.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.exercise.entities.Student;
import com.lab.exercise.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all modules
    public List<String> getAllModules() {
        return studentRepository.findDistinctModules();
    }

    // Get students for a module
    public List<Student> getStudentsByModule(String module) {
        return studentRepository.findByModule(module);
    }

    // Get all students for a module
    public List<Student> getAllStudentsByModule(String module) {
        return studentRepository.findAllByModule(module);
    }

    // Get student by id for a module
    public Student getStudentById(String module, Long id) {
        Optional<Student> optionalStudent = studentRepository.findByIdAndModule(id, module);
        return optionalStudent.orElse(null);
    }

    // Create a new student for a module
    @Transactional
    public Student createStudent(String module, Student student) {
        student.setModule(module);
        return studentRepository.save(student);
    }

    // Update a student for a module
    @Transactional
    public Student updateStudent(String module, Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findByIdAndModule(id, module);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setGrade(updatedStudent.getGrade());
            existingStudent.setGfStamp(updatedStudent.getGfStamp());
            existingStudent.setJgGrade(updatedStudent.getJgGrade());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    // Delete a student for a module
    @Transactional
    public void deleteStudent(String module, Long id) {
        studentRepository.deleteByIdAndModule(id, module);
    }
}
