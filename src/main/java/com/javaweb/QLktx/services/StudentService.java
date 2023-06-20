package com.javaweb.QLktx.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.javaweb.QLktx.models.Student;

@Component
public interface StudentService {

	public Student update(Long id, Student student);
	public ResponseEntity<String> updateRoom(Long id, Long idPhong);
	public Student removeStudentRoom(Long id);
	public Student get(Long id);
	public void delete(Long id);
	public List<Student> getAll();
}