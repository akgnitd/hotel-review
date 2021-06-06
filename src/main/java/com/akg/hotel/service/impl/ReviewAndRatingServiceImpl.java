package com.akg.hotel.service.impl;

import com.akg.hotel.dto.HotelRatingDTO;
import com.akg.hotel.entity.ReviewAndRating;
import com.akg.hotel.exception.EntityDoesNotExistException;
import com.akg.hotel.repository.ReviewAndRatingRepository;
import com.akg.hotel.service.IReviewAndRatingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ReviewAndRatingServiceImpl implements IReviewAndRatingService {

    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;

    @Transactional
    public void saveRating(HotelRatingDTO hotelRatingDTO) {
        ReviewAndRating reviewAndRating = new ReviewAndRating();

        BeanUtils.copyProperties(hotelRatingDTO, reviewAndRating);
        reviewAndRating.setCreatedBy("Admin");
        reviewAndRating.setCreatedOn(new Date());
        reviewAndRating.setModifiedBy("Admin");
        reviewAndRating.setModifiedOn(new Date());

        reviewAndRatingRepository.save(reviewAndRating);
    }

    @Override
    public float fetchRating(Integer hotelId) {

        List<ReviewAndRating> reviewAndRatings = reviewAndRatingRepository.findByHotelId(hotelId);
        if (CollectionUtils.isEmpty(reviewAndRatings)) {
            throw new EntityDoesNotExistException(String.format("No Review and Rating Found for Hotel: %s", hotelId));
        }
        float ratingsSum = 0;
        for (ReviewAndRating reviewAndRating : reviewAndRatings) {
            ratingsSum+= reviewAndRating.getRating();
        }
        float rating = ratingsSum / reviewAndRatings.size();
        return rating;
    }

}
