package com.movie_rating.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;
	
}
