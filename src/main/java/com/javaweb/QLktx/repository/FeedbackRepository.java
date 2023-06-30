package com.javaweb.QLktx.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Serializable>{
	@Query("SELECT f FROM Feedback f WHERE f.student.maSV = :masv")
    List<Feedback> findAllFeedbackByUser(Integer masv);
}
