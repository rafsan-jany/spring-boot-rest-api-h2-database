package com.example.rjany.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.rjany.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
