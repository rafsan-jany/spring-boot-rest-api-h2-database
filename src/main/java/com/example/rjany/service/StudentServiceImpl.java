package com.example.rjany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rjany.model.Student;
import com.example.rjany.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired //inject repository dependency
	StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student); //save student
	}
	
	@Override
	public Student getStudentById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) return student.get();
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>(); //create list of students variable
		studentRepository.findAll().forEach(student ->students.add(student)); // keep each student in students list
		return students;
	}
	
	@Override
	public Student updateStudent(Long id, Student student) {
		Optional<Student> studentById = studentRepository.findById(id);
		
		if(studentById.isPresent()) { 
			Student updatedStudent = studentById.get();
		
			updatedStudent.setId(student.getId());
			updatedStudent.setName(student.getName());
			updatedStudent.setAge(student.getAge());
			updatedStudent.setEmail(student.getEmail());
			
			return studentRepository.save(updatedStudent);
		}
		
		return null;
	}

	@Override
	public String deleteStudent(Long id) {
		studentRepository.deleteById(id); //delete student by id
		return "id" + id + "is deleted successfully"; 
	}
}
