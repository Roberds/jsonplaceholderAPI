package com.robds.jsonplaceholder.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robds.jsonplaceholder.api.dto.PostDto;

public interface PostRepository extends JpaRepository<PostDto, Long> {

}
