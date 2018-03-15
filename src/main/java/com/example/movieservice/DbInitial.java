package com.example.movieservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class DbInitial implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Populating db.");
        Stream.of("1","2").forEach(title -> {
            Movie movie = new Movie();
            movieRepository.save(movie);
        });
    }
}
