package com.javaweb.QLktx.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javaweb.QLktx.models.News;

@Component
public interface NewsService {
	public News save(String username, News news);
	public News update(Long id, News news);
	public News get(Long id);
	public void delete(Long id);
	public List<News> getAll();
	public List<News> getLatestNews();
}
