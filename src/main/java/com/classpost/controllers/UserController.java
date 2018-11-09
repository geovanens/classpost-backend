package com.classpost.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.classpost.models.User;
import com.classpost.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(value = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAll() {
		return this.userService.getAll();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		return this.userService.save(user);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public User update(@RequestBody User user) throws Exception {
		return this.userService.update(user);
	}
	
	@RequestMapping(value = "/exist-username/{username}", method = RequestMethod.GET)
	public Map<String, Boolean> update(@PathVariable String username) {
		HashMap<String, Boolean> result = new HashMap<>();
		User find = this.userService.findByUsername(username);
		result.put("result", find != null);
		return result;
	}

}
