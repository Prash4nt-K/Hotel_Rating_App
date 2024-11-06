package com.movie_rating.RatingService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie_rating.RatingService.entities.RatingEntity;
import com.movie_rating.RatingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<RatingEntity> createtRating (@RequestBody RatingEntity rating){
		RatingEntity tempRating = ratingService.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(tempRating);
	}
	
	@GetMapping
	public ResponseEntity<List<RatingEntity>> getAllRatings (){
		List<RatingEntity> allRatings = ratingService.getAllRatings();
		return ResponseEntity.ok(allRatings);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<RatingEntity>> getRatingByUserId (@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getAllRatingsByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<RatingEntity>> getRatingByHotelId (@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getAllRatingsByHotelId(hotelId));
	}
	
}

