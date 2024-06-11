package com.moviesTVSeries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "tvseries")
public class TVseries extends Media {

    @OneToMany(mappedBy = "tvseries")
    private List<Season> seasons;

    public TVseries(){}
    public TVseries(String title, String description, int suitability, List<String> categories, int releaseDate, List<String> castList, List<String> related, List<Season> seasons) {
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
