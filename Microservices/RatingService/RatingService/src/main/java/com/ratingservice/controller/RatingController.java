package com.ratingservice.controller;


import com.ratingservice.entities.Rating;
import com.ratingservice.sercice.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

//    create rating
    @PostMapping("/create")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        Rating createRate = this.ratingService.create(rating);
        return new ResponseEntity<Rating>(createRate, HttpStatus.CREATED);
    }

//    get all rating

    @GetMapping
    public ResponseEntity<List<Rating>> getRating(){
        return ResponseEntity.ok(ratingService.getRatings());
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable  String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }


    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable  String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
