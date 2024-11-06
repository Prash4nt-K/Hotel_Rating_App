package com.movie_rating.HotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_rating.HotelService.entities.HotelEntity;
import com.movie_rating.HotelService.exceptions.ResourceNotFoundException;
import com.movie_rating.HotelService.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public HotelEntity createHotel(HotelEntity hotel) {
		String randomUserID = UUID.randomUUID().toString();
		hotel.setId(randomUserID);
		return hotelRepository.save(hotel);
	}
	
	@Override
	public List<HotelEntity> getAllHotel(){
		return hotelRepository.findAll();
	}
	
	@Override
	public HotelEntity getHotel(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource with given id is not found on server : "+id));	
	}

	
}
