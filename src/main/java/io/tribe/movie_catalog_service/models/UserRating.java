package io.tribe.movie_catalog_service.models;

import java.util.List;

public class UserRating {
    private String userID;
    private List<Rating> ratings;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
