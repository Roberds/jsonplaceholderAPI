package com.robds.jsonplaceholder.api.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robds.jsonplaceholder.api.client.ApiClient;

@RestController
@RequestMapping("/api")
public class UserPostController {
	
	@GetMapping("/user/{id}")
	public String getUserById(@PathVariable Long id) throws IOException, InterruptedException {
		ApiClient client = new ApiClient();
		
		return client.connectUserById(id).toString();
	}

}
