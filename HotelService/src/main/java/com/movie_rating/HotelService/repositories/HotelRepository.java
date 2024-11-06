package com.movie_rating.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_rating.HotelService.entities.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, String> {

}
