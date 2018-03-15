package com.example.movieservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash
@ToString
public class Movie {

    @Id
    private String id;
    private String title, genre;
}
