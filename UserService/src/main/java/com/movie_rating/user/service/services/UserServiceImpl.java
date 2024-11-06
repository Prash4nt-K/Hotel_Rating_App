package com.movie_rating.user.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_rating.user.service.entities.UserEntity;
import com.movie_rating.user.service.exceptions.ResourceNotFoundException;
import com.movie_rating.user.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity saveUSer(UserEntity user) {
		String randomUserID = UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		return userRepository.save(user);
	}

	@Override
	public List<UserEntity> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resource with given id is not found on server : "+userId));
	}
	
}
