package com.moviesSeries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "series")
public class Series extends Media {

    @OneToMany(mappedBy = "tvseries")
    private List<Season> seasons;

    public Series(){}
    public Series(String title, String description, int suitability, List<String> categories, int releaseDate, List<String> castList, List<String> related, List<Season> seasons) {
        super(title, description, suitability, categories, releaseDate, castList, related);
        this.seasons = seasons;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
