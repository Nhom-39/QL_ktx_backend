package com.javaweb.QLktx.serviceimpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.models.Admin;
import com.javaweb.QLktx.models.News;
import com.javaweb.QLktx.models.User;
import com.javaweb.QLktx.repository.AdminRepository;
import com.javaweb.QLktx.repository.NewsRepository;
import com.javaweb.QLktx.repository.UserRepository;
import com.javaweb.QLktx.services.NewsService;

import jakarta.transaction.Transactional;

@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public News save(String username, News news) {
		User user = userRepository.findByTaiKhoan(username);
		
		Admin admin = adminRepository.findByIdUser(user.getId());
			       
		News n = new News();
		n.setTieuDe(news.getTieuDe());
		n.setNoiDung(news.getNoiDung());
		n.setImage(news.getImage());
		n.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		n.setAdmin(admin);
		News createResponse = newsRepository.save(n);
		return createResponse;
	}

	@Transactional
	public News update(Long id, News news) {
		News n = newsRepository.findById(id)
			       .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
		n.setTieuDe(news.getTieuDe());
		n.setNoiDung(news.getNoiDung());
		n.setImage(news.getImage());
		n.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		News updateResponse = newsRepository.save(n);
		return updateResponse;
	}

	@Transactional
	public News get(Long id) {
		Optional<News> response = newsRepository.findById(id);
		News getResponse = response.get();
		return getResponse;
	}

	@Transactional
	public void delete(Long id) {
		newsRepository.deleteById(id);
	}
	
	@Transactional
	public List<News> getAll() {
	    return newsRepository.findAll();
	}
	
	@Transactional
	public List<News> getLatestNews() {
        return newsRepository.findTop3ByOrderByCreatedAtDesc();
    }
}
