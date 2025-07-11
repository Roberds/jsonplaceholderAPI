package com.robds.jsonplaceholder.api.model;

import java.util.List;

import com.robds.jsonplaceholder.api.dto.PostDto;

public class UserPost {

	private String name;
	private String email;
	private List<PostDto> posts;

	public UserPost() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PostDto> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDto> posts) {
		this.posts = posts;
	}

}
