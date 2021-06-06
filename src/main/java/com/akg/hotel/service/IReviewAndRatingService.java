package com.akg.hotel.service;

import com.akg.hotel.dto.HotelRatingDTO;

import java.io.IOException;

public interface IReviewAndRatingService {

    void saveRating(HotelRatingDTO hotelRatingDTO) throws IOException;

    float fetchRating(Integer hotelId);
}
