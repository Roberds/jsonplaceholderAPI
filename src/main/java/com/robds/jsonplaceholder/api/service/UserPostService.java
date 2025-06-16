package com.robds.jsonplaceholder.api.service;

import java.io.IOException;

import com.robds.jsonplaceholder.api.dto.UserDto;
import com.robds.jsonplaceholder.api.model.UserPost;

public interface UserPostService {
	
	UserDto findUser(Long id) throws IOException, InterruptedException;
	
	UserPost getPostByUser(Long id) throws IOException, InterruptedException;

}
