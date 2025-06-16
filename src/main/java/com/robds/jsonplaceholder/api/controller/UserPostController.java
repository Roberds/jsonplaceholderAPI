package com.robds.jsonplaceholder.api.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robds.jsonplaceholder.api.dto.UserDto;
import com.robds.jsonplaceholder.api.model.UserPost;
import com.robds.jsonplaceholder.api.service.UserPostService;

@RestController
@RequestMapping("/api")
public class UserPostController {
	
	@Autowired
	private UserPostService userPostService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) throws IOException, InterruptedException {
		
		return ResponseEntity.ok().body(userPostService.findUser(id));
	}
	
	@GetMapping("user/post/{id}")
	public ResponseEntity<UserPost> getPostByUser(@PathVariable Long id) throws IOException, InterruptedException {
		return ResponseEntity.ok().body(userPostService.getPostByUser(id));
	}
	

}
