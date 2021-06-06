package com.akg.hotel.entity;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "review_and_rating")
public class ReviewAndRating extends BaseEntity {

    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "HOTEL_ID")
    private Integer hotelId;
    @Column(name = "RATING")
    private float rating;
    @Column(name = "REVIEW")
    private String review;
    @Column(name = "IS_ANONYMOUS")
    private boolean isAnonymous;
    @Column(name = "USER_NAME")
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @PrePersist
    private void generateId() {
        if (id == null) {
            Integer code = ThreadLocalRandom.current().nextInt(10000000, 100000000);
            id = code;
        }
    }
}
