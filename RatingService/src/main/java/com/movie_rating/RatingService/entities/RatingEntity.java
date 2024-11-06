package com.movie_rating.RatingService.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ratings")
public class RatingEntity {
	
	@Id
	@Column(name="ID")
	private String ratingId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="HOTEL_ID")
	private String hotelId;
	
	@Column(name="RATING")
	private int rating;
	
	@Column(name="FEEDBACK")
	private String feedback;
	
}

