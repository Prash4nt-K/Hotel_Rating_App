package com.movie_rating.user.service.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.movie_rating.user.service.entities.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {
	
	@GetMapping("/ratings/users/{userId}")
	Rating [] getAllRatings(@PathVariable String userId);
	
}
