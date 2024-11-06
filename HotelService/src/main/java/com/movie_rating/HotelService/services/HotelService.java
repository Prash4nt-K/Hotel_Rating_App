package com.movie_rating.HotelService.services;

import java.util.List;

import com.movie_rating.HotelService.entities.HotelEntity;

public interface HotelService {
	
	HotelEntity createHotel(HotelEntity hotelEntity);
	
	List<HotelEntity> getAllHotel();
	
	HotelEntity getHotel(String id);
	
}
