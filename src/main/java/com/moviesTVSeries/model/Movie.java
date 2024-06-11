package com.moviesTVSeries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "movies")
public class Movie extends Media {
    private int duration;

    public Movie(){
    }

    public Movie(String title, String description, int suitability, List<String> categories, int releaseDate, List<String> castList, List<String> related, int duration) {
        super(title, description, suitability, categories, releaseDate, castList, related);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
