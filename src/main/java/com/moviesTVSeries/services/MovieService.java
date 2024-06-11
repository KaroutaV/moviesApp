package com.moviesTVSeries.services;

import com.moviesTVSeries.model.Movie;
import com.moviesTVSeries.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        Optional<Movie> movieOptional =
                movieRepository.findByTitle(movie.getTitle());
        if(movieOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Movie with tile "+movie.getTitle()+
                            "already exists!");
        movieRepository.save(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
