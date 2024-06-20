package com.moviesSeries.controllers;

import com.moviesSeries.model.Series;
import com.moviesSeries.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("series")
public class SeriesController {
    @Autowired
    SeriesService seriesService;

    @PostMapping
    public Series addTVseries(@RequestBody Series tvSeries){
        return seriesService.addTVSeries(tvSeries);
    }

    @GetMapping("getAll")
    public List<Series> getAll(){
        return seriesService.getAll();
    }
}
