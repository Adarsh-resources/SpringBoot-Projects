package com.ratingservice.sercice;


import com.ratingservice.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {



//    create
    Rating create(Rating rating);

// get all rating
    List<Rating> getRatings();

//    get all by user
    List<Rating> getRatingByUserId(String userId);

//    get all by hotels
    List<Rating> getRatingByHotelId(String hotelId);

}
