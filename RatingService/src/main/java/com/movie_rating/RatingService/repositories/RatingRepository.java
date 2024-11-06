package com.movie_rating.RatingService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_rating.RatingService.entities.RatingEntity;

public interface RatingRepository extends JpaRepository<RatingEntity, String> {
	
	List<RatingEntity> findByUserId(String userId);
	
	List<RatingEntity> findByHotelId(String hotelId);
	
}
