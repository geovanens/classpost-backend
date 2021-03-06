package com.classpost.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.classpost.models.Post;
import com.classpost.services.PostService;

@RestController
@RequestMapping(value = "/post")
@CrossOrigin(value = "*")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Post> getAll() {
		return this.postService.getAll();
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public List<Post> findByEmail(@PathVariable String email) {
		return this.postService.findByEmail(email);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Post save(@RequestBody Post post) {
		return this.postService.save(post);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Post update(@RequestBody Post post, @PathVariable Long id) {
		return this.postService.update(post, id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
    public Post delete(@RequestBody Post post) {
	    return this.postService.delete(post);
    }
	
	@RequestMapping(value = "/{id}/like", method = RequestMethod.PUT)
    public Post like(@PathVariable Long id) {
	    return this.postService.like(id);
    }
	
	@RequestMapping(value = "/{id}/unlike", method = RequestMethod.PUT)
    public Post unlike(@PathVariable Long id) {
	    return this.postService.unlike(id);
    }
	
	@RequestMapping(value = "note/{id}/{note}", method = RequestMethod.PUT)
    public Post unlike(@PathVariable Long id, @PathVariable Double note) {
	    return this.postService.addNote(id, note);
    }

}
