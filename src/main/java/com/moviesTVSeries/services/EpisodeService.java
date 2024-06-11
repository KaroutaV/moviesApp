package com.moviesTVSeries.services;

import com.moviesTVSeries.model.Episode;
import com.moviesTVSeries.repositories.EpisodeRepository;
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
