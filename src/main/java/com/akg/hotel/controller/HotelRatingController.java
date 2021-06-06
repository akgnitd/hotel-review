package com.akg.hotel.controller;

import com.akg.hotel.dto.HotelRatingDTO;
import com.akg.hotel.dto.ResponseDTO;
import com.akg.hotel.exception.ExceptionHandler;
import com.akg.hotel.service.IReviewAndRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelRatingController {

    private static Logger LOGGER = LoggerFactory.getLogger(HotelRatingController.class);

    @Autowired
    IReviewAndRatingService reviewAndRatingService;

    @Autowired
    ExceptionHandler exceptionHandler;

    @PostMapping(path = "/rating", produces = "application/json", name = "Endpoint for Adding a new Rating")
    public @ResponseBody
    ResponseEntity postRating(@RequestBody HotelRatingDTO hotelRatingDTO) {

        ResponseDTO responseDTO;
        try {
            reviewAndRatingService.saveRating(hotelRatingDTO);
        } catch (Exception ex) {
            LOGGER.error("Exception happened while saving rating for hotel: {}", hotelRatingDTO.getHotelId(), ex);
            responseDTO = exceptionHandler.mapAndThrow(ex);
            return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getCode()));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/rating/{hotelId}", name = "Endpoint for getting average Rating of Hotel")
    public ResponseEntity getRatings(@PathVariable Integer hotelId) {
        ResponseDTO responseDTO;
        float reviewAndRatings;
        try {
            reviewAndRatings = reviewAndRatingService.fetchRating(hotelId);
        } catch (Exception ex) {
            LOGGER.error("Exception happened while saving rating for hotel: {}", hotelId, ex);
            responseDTO = exceptionHandler.mapAndThrow(ex);
            return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getCode()));
        }
        return new ResponseEntity<>(reviewAndRatings, HttpStatus.OK);
    }
}
