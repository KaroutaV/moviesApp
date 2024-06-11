package com.moviesTVSeries.services;

import com.moviesTVSeries.model.Episode;
import com.moviesTVSeries.model.Season;
import com.moviesTVSeries.model.TVseries;
import com.moviesTVSeries.repositories.EpisodeRepository;
import com.moviesTVSeries.repositories.SeasonRepository;
import com.moviesTVSeries.repositories.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TVseriesService {

    @Autowired TVSeriesRepository tvSeriesRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    EpisodeRepository episodeRepository;

    @Autowired SeasonService seasonService;
    @Autowired EpisodeService episodeService;

    public TVseries addTVSeries(TVseries tvseries){
        Optional<TVseries> movieOptional =
                tvSeriesRepository.findByTitle(tvseries.getTitle());
        if(movieOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Movie with tile "+tvseries.getTitle()+
                            "already exists!");

        List<Season> seasons1 = tvseries.getSeasons();

        seasonService.createSeason(seasons1);
        for(Season s: seasons1){
            List<Episode> episodes1 = s.getEpisodes();
            s.setEpisodes(episodes1);
            seasonRepository.save(s);
            episodeService.createEpisode(episodes1);
            for (Episode e: episodes1){
                e.setSeason(s);
                episodeRepository.save(e);
            }
        }
        tvSeriesRepository.save(tvseries);
        return tvseries;

    }
    public List<TVseries> getAll() {
        return tvSeriesRepository.findAll();
    }
}
