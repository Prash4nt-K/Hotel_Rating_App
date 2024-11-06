package com.movie_rating.user.service.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie_rating.user.service.entities.Hotel;
import com.movie_rating.user.service.entities.Rating;
import com.movie_rating.user.service.entities.UserEntity;
import com.movie_rating.user.service.services.HotelService;
import com.movie_rating.user.service.services.RatingService;
import com.movie_rating.user.service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<UserEntity> createtUser (@RequestBody UserEntity user){
		UserEntity tempUser = userService.saveUSer(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(tempUser);
	}
	
	@CircuitBreaker(name="RATING_HOTEL_BREAKER", fallbackMethod="ratingHotelFallback")
	@GetMapping("{userId}")
	public ResponseEntity<UserEntity> getUser (@PathVariable String userId){
		UserEntity tempUser = userService.getUser(userId);
		 
		Rating [] ratings = ratingService.getAllRatings(userId);
		
		List<Rating> allRatings = Arrays.stream(ratings).toList();
		
		List<Rating> ratingsList = allRatings.stream().map(rating -> {
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
			}).collect(Collectors.toList());
	
		tempUser.setRatings(ratingsList);
		return ResponseEntity.ok(tempUser);
	}
	
	public ResponseEntity<UserEntity> ratingHotelFallback (String userId, Exception ex){
		
		UserEntity user = UserEntity.builder()
								.userId("12345")
								.name("Dummy User")
								.email("Dummy@dev.com")
								.about("This is a dummy user.")
								.build();
		
		System.out.println("Something went wrong : "+ex);
			
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUser (){
		List<UserEntity> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
