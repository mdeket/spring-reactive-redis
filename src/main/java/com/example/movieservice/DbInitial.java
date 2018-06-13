package com.example.movieservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.UUID;

@Component
@Slf4j
public class DbInitial implements CommandLineRunner {

    private final MovieRepository posts;

    public DbInitial(MovieRepository posts) {
        this.posts = posts;
    }

    @Override
    public void run(String[] args) {
        log.info("Redis initialization");
        this.posts
            .deleteAll()
            .thenMany(
                    Flux.just("Top Gun", "Transformers", "Pirates of Caribbean")
                            .flatMap(movieTitle -> {
                                Movie movie = new Movie(UUID.randomUUID().toString(), movieTitle);
                                return posts.save(movie);
                            })
            )
            .log()
            .subscribe(
                    System.out::println,
                    null,
                    () -> log.info("Done initialization")
            );
    }

}
