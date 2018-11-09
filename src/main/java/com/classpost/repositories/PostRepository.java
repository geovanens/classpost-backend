package com.classpost.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.classpost.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("select p from Post p where p.email = ?1")
	List<Post> postsByEmail(String email);

}
