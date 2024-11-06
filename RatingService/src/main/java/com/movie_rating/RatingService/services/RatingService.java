package com.movie_rating.RatingService.services;

import java.util.List;

import com.movie_rating.RatingService.entities.RatingEntity;

public interface RatingService {
	
	RatingEntity saveRating(RatingEntity rating);
	
	List<RatingEntity> getAllRatings();
	
	List<RatingEntity> getAllRatingsByUserId(String userId);
	
	List<RatingEntity> getAllRatingsByHotelId(String hotelId);
	
}
