package com.javaweb.QLktx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.QLktx.models.Feedback;
import com.javaweb.QLktx.services.FeedbackService;

@RestController
@RequestMapping("")
public class FeedbackController {
	@Autowired
	private FeedbackService feedBackService;
	
	@GetMapping("/user/bao-cao-va-phan-hoi/{masv}")
	public List<Feedback> getAllFeedback(@PathVariable Integer masv) {
		List<Feedback> feedbacks = feedBackService.getAllByUser(masv);
        return feedbacks;
	}
	
	@GetMapping("/admin/phan-hoi-y-kien")
	public List<Feedback> getAllRoom() {
		List<Feedback> feedbacks = feedBackService.getAll();
        return feedbacks;
	}

	@PostMapping("/user/{masv}/bao-cao-va-phan-hoi/create")
	public Feedback createReport(@PathVariable Integer masv, @RequestBody Feedback feedback) {
		Feedback createResponse = feedBackService.save(masv, feedback);
		return createResponse;
	}
	
	@PutMapping("/admin/phan-hoi-y-kien/{id}/{username}")
	public Feedback updateFeedback(@PathVariable Long id, @PathVariable String username,  @RequestBody Feedback feedback) {
		Feedback updateResponse = feedBackService.update(id, username, feedback);
		return updateResponse;
	}

	@GetMapping("/{id}/edit")
	public Feedback getFeedback(@PathVariable Long id) {
		Feedback getReponse = feedBackService.get(id);
		return getReponse;
	}

	@DeleteMapping("/admin/bao-cao-va-phan-hoi/{id}")
	public String deleteFeedback(@PathVariable Long id) {
		feedBackService.delete(id);
		return "Xóa phản hồi thành công";
	}
}
