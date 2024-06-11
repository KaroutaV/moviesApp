package com.moviesTVSeries.model;

import jakarta.persistence.*;

import java.util.*;

@MappedSuperclass
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int suitability;
    private List<String> categories;
    private int releaseDate;
    private List<String> castList;
    private List<String> related;

    public Media(){}
    public Media(String title, String description, int suitability, List<String> categories, int releaseDate, List<String> castList, List<String> related) {
        this.title = title;
        this.description = description;
        this.suitability = suitability;
        this.categories = categories;
        this.releaseDate = releaseDate;
        this.castList = castList;
        this.related = related;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSuitability() {
        return suitability;
    }

    public void setSuitability(int suitability) {
        this.suitability = suitability;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getCastList() {
        return castList;
    }

    public void setCastList(List<String> castList) {
        this.castList = castList;
    }

    public List<String> getRelated() {
        return related;
    }

    public void setRelated(List<String> related) {
        this.related = related;
    }
}
