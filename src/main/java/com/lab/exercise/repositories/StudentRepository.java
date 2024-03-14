package com.lab.exercise.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.exercise.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByModule(String module);
    List<Student> findAllByModule(String module);
    Optional<Student> findByIdAndModule(Long id, String module);
    void deleteByIdAndModule(Long id, String module);
    List<String> findDistinctModules();
}

