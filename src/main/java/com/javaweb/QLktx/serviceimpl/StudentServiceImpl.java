package com.javaweb.QLktx.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.models.Room;
import com.javaweb.QLktx.models.Student;
import com.javaweb.QLktx.repository.RoomRepository;
import com.javaweb.QLktx.repository.StudentRepository;
import com.javaweb.QLktx.services.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	public Student update(Student student) {
		Student updateResponse = studentRepository.save(student);
		return updateResponse;
	}
	
	@Transactional
	public Student updateRoom(Long id, Long idPhong) {
		Student student = studentRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		Room room = roomRepository.findById(idPhong)
		        .orElseThrow(() -> new RuntimeException("Room not found with id: " + idPhong));
		student.setRoom(room);
		Student updateResponse = studentRepository.save(student);
		return updateResponse;
	}
	
	@Transactional
	public Student removeStudentRoom(Long id) {
		Student student = studentRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		student.setRoom(null);
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