package com.moviesTVSeries.controllers;

import com.moviesTVSeries.model.Episode;
import com.moviesTVSeries.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    EpisodeService episodeService;

    @GetMapping("/getall")
    public List<Episode> getAllEpisode(){
        return episodeService.getAllEpisodes();
    }
}
