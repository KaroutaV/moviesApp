package com.moviesSeries.controllers;

import com.moviesSeries.model.Season;
import com.moviesSeries.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/seasons")
public class SeasonController {
    @Autowired
    SeasonService seasonService;

    @GetMapping("/getall")
    public List<Season> getAllSeasons(){
        return seasonService.getAllSeasons();
    }
}
