package com.classpost.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classpost.models.Post;
import com.classpost.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public Post save(Post post) {
		post.setCreateDate(LocalDateTime.now());
		return this.postRepository.save(post);
	}
	
	public List<Post> getAll() {
		return this.postRepository.findAll();
	}
	
	public Post update(Post post, Long id) {
		Post saved = this.postRepository.getOne(id);
		saved.setText(post.getText());
		saved.setLocation(post.getLocation());
		this.postRepository.save(saved);
		return saved;
	}
	
	public List<Post> findByEmail(String email) {
		return this.postRepository.postsByEmail(email);
	}
	
	public Post delete(Post post) {
		this.postRepository.delete(post);
		return post;
	}

	public Post like(Long id) {
		Post saved = this.postRepository.getOne(id);
		saved.like();
		this.postRepository.save(saved);
		return saved;
	}
	
	public Post unlike(Long id) {
		Post saved = this.postRepository.getOne(id);
		saved.unlike();
		this.postRepository.save(saved);
		return saved;
	}
	
	public Map<String, Double> getAverage(Long id) {
		Post saved = this.postRepository.getOne(id);
		HashMap<String, Double> result = new HashMap<>();
		result.put("average", saved.averageNotes());
		return result;
	}

	public Post addNote(Long id, Double note) {
		Post saved = this.postRepository.getOne(id);
		saved.addNote(note);
		this.postRepository.save(saved);
		return saved;
	}

}
