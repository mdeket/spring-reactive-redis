package com.example.movieservice;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovieRepository {

    private ReactiveRedisOperations<String, Movie> template;

    public MovieRepository(ReactiveRedisOperations<String, Movie> template) {
        this.template = template;
    }

    Flux<Movie> findAll() {
        return template.<String, Movie>opsForHash().values("movies");
    }

    Mono<Movie> save(Movie movie) {
        return template.<String, Movie>opsForHash().put("movies", movie.getId(), movie)
                .log()
                .map(p -> movie);
    }

    Mono<Boolean> deleteAll() {
        return template.<String, Movie>opsForHash().delete("movies");
    }
}

