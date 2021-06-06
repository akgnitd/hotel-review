package com.akg.hotel.repository;

import com.akg.hotel.entity.ReviewAndRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewAndRatingRepository extends JpaRepository<ReviewAndRating, Integer> {


    List<ReviewAndRating> findByHotelId(Integer hotelId);
}
