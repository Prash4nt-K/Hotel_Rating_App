package com.movie_rating.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_rating.user.service.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
