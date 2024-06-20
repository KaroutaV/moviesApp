package com.moviesSeries.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name= "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int releasedYear;
    @ManyToOne
    @JoinColumn(name = "series_id", referencedColumnName = "id")
    @JsonIgnore
    private Series tvseries;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;

    public Season(){}
    public Season(Long seasonNumber, int releasedYear, List<Episode> episodes) {
        this.id = seasonNumber;
        this.releasedYear = releasedYear;
        this.episodes = episodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Series getTvseries() {
        return tvseries;
    }

    public void setTvseries(Series tvseries) {
        this.tvseries = tvseries;
    }
    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
