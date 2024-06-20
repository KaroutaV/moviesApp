package com.moviesSeries.repositories;

import com.moviesSeries.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Long> {
    Optional<Series> findByTitle(String title);
}
