package com.moviesSeries.services;

import com.moviesSeries.model.Episode;
import com.moviesSeries.model.Season;
import com.moviesSeries.model.Series;
import com.moviesSeries.repositories.EpisodeRepository;
import com.moviesSeries.repositories.SeasonRepository;
import com.moviesSeries.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {

    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    EpisodeRepository episodeRepository;

    @Autowired SeasonService seasonService;
    @Autowired EpisodeService episodeService;

    public Series addTVSeries(Series tvseries){
        Optional<Series> movieOptional =
                seriesRepository.findByTitle(tvseries.getTitle());
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
        seriesRepository.save(tvseries);
        return tvseries;

    }
    public List<Series> getAll() {
        return seriesRepository.findAll();
    }
}
