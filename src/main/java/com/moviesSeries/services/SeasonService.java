package com.moviesSeries.services;

import com.moviesSeries.model.Season;
import com.moviesSeries.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    @Autowired
    SeasonRepository seasonRepository;
    public List<Season> createSeason(List<Season> seasons) {
        for(Season s : seasons){
            seasonRepository.save(s);
        }
        return seasons;
    }

    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }
}
