package com.javaweb.QLktx.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.models.Student;
import com.javaweb.QLktx.repository.StudentRepository;
import com.javaweb.QLktx.services.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public Student save(Student student) {
		Student createResponse = studentRepository.save(student);
		return createResponse;
	}

	@Transactional
	public Student update(Student student) {
		Student updateResponse = studentRepository.save(student);
		return updateResponse;
	}

	@Transactional
	public Student get(Long id) {
		Optional<Student> response = studentRepository.findById(id);
		Student getResponse = response.get();
		return getResponse;
	}

	@Transactional
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public List<Student> getAll() {
	    return studentRepository.findAll();
	}
}