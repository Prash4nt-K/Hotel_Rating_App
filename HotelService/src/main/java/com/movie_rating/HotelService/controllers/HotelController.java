package com.movie_rating.HotelService.controllers;

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

import com.movie_rating.HotelService.entities.HotelEntity;
import com.movie_rating.HotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<HotelEntity> createHotel (@RequestBody HotelEntity hotel){
		HotelEntity tempHotel = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(tempHotel);
	}
	
	@GetMapping("{hotelId}")
	public ResponseEntity<HotelEntity> getHotel (@PathVariable String hotelId){
		HotelEntity tempHotel = hotelService.getHotel(hotelId);
		return ResponseEntity.ok(tempHotel);
	}
	
	@GetMapping
	public ResponseEntity<List<HotelEntity>> getAllHotels (){
		List<HotelEntity> allHotel = hotelService.getAllHotel();
		return ResponseEntity.ok(allHotel);
	}
	
}
