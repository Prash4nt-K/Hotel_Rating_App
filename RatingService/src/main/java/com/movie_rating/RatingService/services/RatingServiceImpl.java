package com.movie_rating.RatingService.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_rating.RatingService.entities.RatingEntity;
import com.movie_rating.RatingService.repositories.RatingRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public RatingEntity saveRating(RatingEntity rating) {
		String randomRatingID = UUID.randomUUID().toString();
		rating.setRatingId(randomRatingID);
		return ratingRepository.save(rating);
	}

	@Override
	public List<RatingEntity> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<RatingEntity> getAllRatingsByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<RatingEntity> getAllRatingsByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
	
