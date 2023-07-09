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

import com.javaweb.QLktx.models.News;
import com.javaweb.QLktx.services.NewsService;

@RestController
@RequestMapping("")
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	@GetMapping({"/admin/quan-ly-thong-bao", "/thong-bao"})
	public List<News> getAllRoom() {
		List<News> news = newsService.getAll();
        return news;
	}
	
	@PostMapping("/admin/quan-ly-thong-bao/create/{username}")
	public News createNews(@PathVariable String username, @RequestBody News news) {
		News createResponse = newsService.save(username, news);
		return createResponse;
	}
	
	@GetMapping({"/admin/quan-ly-thong-bao/{id}", "/thong-bao/{id}"})
	public News getNewsInfo(@PathVariable Long id) {
		News getReponse = newsService.get(id);
		return getReponse;
	}
	
	@PutMapping("/admin/quan-ly-thong-bao/{id}")
	public News updateNews(@PathVariable Long id, @RequestBody News news) {
		News updateResponse = newsService.update(id, news);
		return updateResponse;
	}

	@GetMapping("/admin/quan-ly-thong-bao/{id}/edit")
	public News getNews(@PathVariable Long id) {
		News getReponse = newsService.get(id);
		return getReponse;
	}

	@DeleteMapping("/admin/quan-ly-thong-bao/{id}")
	public String deleteNews(@PathVariable Long id) {
		newsService.delete(id);
		return "Xóa thông báo thành công";
	}
	
	 @GetMapping("/latest-news")
	 public List<News> getLatestNews() {
	    return newsService.getLatestNews();
	 }
}
