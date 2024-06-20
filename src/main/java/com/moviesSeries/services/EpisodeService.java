package com.moviesSeries.services;

import com.moviesSeries.model.Episode;
import com.moviesSeries.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;
    public List<Episode> createEpisode(List<Episode> episodes) {
        for(Episode e : episodes){
            episodeRepository.save(e);
        }
        return episodes;
    }

    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }
}
