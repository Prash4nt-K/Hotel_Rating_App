package com.movie_rating.user.service.services;

import java.util.List;

import com.movie_rating.user.service.entities.UserEntity;

public interface UserService {
	
	UserEntity saveUSer(UserEntity user);
	
	List<UserEntity> getAllUser();
	
	UserEntity getUser(String userId);
	
}
