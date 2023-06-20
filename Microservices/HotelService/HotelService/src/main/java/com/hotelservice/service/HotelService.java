package com.hotelservice.service;

import com.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {


//    create hotel
    Hotel create(Hotel hotel);


//get all hotel
    List<Hotel>getAll();


//    get single hotel
    Hotel get(String id);
}
