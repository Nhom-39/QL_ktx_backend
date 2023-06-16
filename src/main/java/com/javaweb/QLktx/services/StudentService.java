package com.javaweb.QLktx.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javaweb.QLktx.models.Student;

@Component
public interface StudentService {

	public Student save(Student student);
	public Student update(Student student);
	public Student get(Long id);
	public void delete(Long id);
	public List<Student> getAll();
}