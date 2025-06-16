package com.robds.jsonplaceholder.api.service.impl;


import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robds.jsonplaceholder.api.client.ApiClient;
import com.robds.jsonplaceholder.api.dto.PostDto;
import com.robds.jsonplaceholder.api.dto.UserDto;
import com.robds.jsonplaceholder.api.model.UserPost;
import com.robds.jsonplaceholder.api.service.UserPostService;


@Service
public class UserPostServiceImpl implements UserPostService{
	
	@Autowired
	private ApiClient client;

	@Override
	public UserDto findUser(Long id) throws IOException, InterruptedException {
		ObjectMapper mapper = new ObjectMapper();
		HttpResponse<String> usersApi = client.connectUserById(id);
		JsonNode root = mapper.readTree(usersApi.body());
		
		UserDto response = new UserDto();
		response.setId(root.get("id").asLong());
		response.setName(root.get("name").asText());
		response.setEmail(root.get("email").asText());
		response.setCompany(root.get("company").get("name").asText());
		response.setWebsite(root.get("website").asText());
		
		
		return response;
	}

	@Override
	public UserPost getPostByUser(Long id) throws IOException, InterruptedException {
		UserPost response = new UserPost();
		List<PostDto> posts = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		HttpResponse<String> postApi = client.connectPotsUserById(id);
		JsonNode root = mapper.readTree(postApi.body());
		
		UserDto user = findUser(id);
		
		for(JsonNode node: root) {
			PostDto post = new PostDto();
			post.setId(node.get("id").asLong());
			post.setTitle(node.get("title").asText());
			post.setBody(node.get("body").asText());
			posts.add(post);
		}
		
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setPosts(posts);
		
		
		return response;
	}
	
	

}
