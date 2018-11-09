package com.classpost.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classpost.models.Post;
import com.classpost.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public Post save(Post post) {
		return this.postRepository.save(post);
	}
	
	public List<Post> getAll() {
		return this.postRepository.findAll();
	}
	
	public Post update(Post post, Long id) {
		Post saved = this.postRepository.getOne(id);
		saved.setText(post.getText());
		saved.setLocation(saved.getLocation());
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
}
