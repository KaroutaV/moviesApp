package com.moviesTVSeries.controllers;

import com.moviesTVSeries.model.Episode;
import com.moviesTVSeries.model.Season;
import com.moviesTVSeries.model.TVseries;
import com.moviesTVSeries.services.TVseriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tvseries")
public class TVSeriesController {

    @Autowired
    TVseriesService tVseriesService;

    // εδω να το κανω μονο να βαζει το tvseries !!!
//    @PostMapping
//    public TVseries addTVseries(@RequestBody TVseries tVseries, @RequestBody List<Episode> episodes, List<Season> season){
//        return tVseriesService.addTVSeries(tVseries,episodes,season);
//    }
    @PostMapping
    public TVseries addTVseries(@RequestBody TVseries tvSeries){
        return tVseriesService.addTVSeries(tvSeries);
    }

    @GetMapping("getAll")
    public List<TVseries> getAll(){
        return tVseriesService.getAll();
    }
}
