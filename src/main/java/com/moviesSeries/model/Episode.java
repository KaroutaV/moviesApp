package com.moviesSeries.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name= "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duration;

    @ManyToOne
    @JoinColumn(name="season_id", referencedColumnName = "id")
    @JsonIgnore
    private Season season;

    public Episode(){}
    public Episode(Long episodeNumber, int duration) {
        this.id = episodeNumber;
        this.duration = duration;
    }
    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Long getEpisodeNumber() {
        return id;
    }

    public void setEpisodeNumber(Long episodeNumber) {
        this.id = episodeNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
