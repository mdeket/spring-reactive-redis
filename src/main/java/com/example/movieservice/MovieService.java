package com.example.movieservice;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }

}
