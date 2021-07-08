package com.example.rjany.service;

import java.util.List;

import com.example.rjany.model.Student;

public interface StudentService {
	
	List<Student> getAllStudent();
	Student getStudentById(Long id);
	Student saveStudent(Student student);
	String deleteStudent(Long id);
	Student updateStudent(Long id, Student student);
	

}
