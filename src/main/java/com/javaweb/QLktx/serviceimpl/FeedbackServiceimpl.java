package com.javaweb.QLktx.serviceimpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.models.Feedback;
import com.javaweb.QLktx.models.Student;
import com.javaweb.QLktx.repository.FeedbackRepository;
import com.javaweb.QLktx.repository.StudentRepository;
import com.javaweb.QLktx.services.FeedbackService;

import jakarta.transaction.Transactional;

@Service
public class FeedbackServiceimpl implements FeedbackService{
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Feedback save(Integer masv, Feedback feedback) {
		Student student = studentRepository.findByMaSV(masv);
		Feedback fb = new Feedback();
		fb.setStudent(student);
		fb.setTieuDe(feedback.getTieuDe());
		fb.setNoiDung(feedback.getNoiDung());
		fb.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		Feedback createResponse = feedbackRepository.save(fb);
		return createResponse;
	}

	@Transactional
	public Feedback update(Long id, Feedback feedback) {
		Feedback fb = feedbackRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		fb.setTraLoi(feedback.getTraLoi());
		Feedback updateResponse = feedbackRepository.save(fb);
		return updateResponse;
	}
	
	public Feedback get(Long id) {
		Optional<Feedback> response = feedbackRepository.findById(id);
		Feedback getResponse = response.get();
		return getResponse;
	}

	@Transactional
	public void delete(Long id) {
		feedbackRepository.deleteById(id);
	}
	
	@Transactional
	public List<Feedback> getAllByUser(Integer masv) {
	    return feedbackRepository.findAllFeedbackByUser(masv);
	}
	
	@Transactional
	public List<Feedback> getAll() {
	    return feedbackRepository.findAll();
	}
	
}
