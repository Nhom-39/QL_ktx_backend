package com.javaweb.QLktx.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javaweb.QLktx.models.Feedback;

@Component
public interface FeedbackService {
	public Feedback save(Integer masv, Feedback feedback);
	public Feedback update(Long id, Feedback feedback);
	public Feedback get(Long id);
	public void delete(Long id);
	public List<Feedback> getAllByUser(Integer masv);
	public List<Feedback> getAll();
}
