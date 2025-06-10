package com.robds.jsonplaceholder.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robds.jsonplaceholder.api.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long>{

}
