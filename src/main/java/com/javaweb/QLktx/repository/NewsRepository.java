package com.javaweb.QLktx.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Serializable>{
	 @Query("SELECT n FROM News n ORDER BY n.createdAt DESC LIMIT 3")
	    List<News> findTop3ByOrderByCreatedAtDesc();
}
