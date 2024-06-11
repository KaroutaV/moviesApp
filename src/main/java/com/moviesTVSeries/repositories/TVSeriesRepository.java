package com.moviesTVSeries.repositories;

import com.moviesTVSeries.model.Movie;
import com.moviesTVSeries.model.TVseries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TVSeriesRepository extends JpaRepository<TVseries,Long> {
    Optional<TVseries> findByTitle(String title);
}
