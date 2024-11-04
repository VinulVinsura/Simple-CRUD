package com.example.moviemanagement.repository;

import com.example.moviemanagement.entity.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ManagerRepo extends JpaRepository<Movie,Long> {

    boolean existsByImdb(String imdb);
    List<Movie> findByImdb(String imdb);
    void deleteAllByImdb(String imdb);

    Optional<Movie> findByImdbEquals(String imdb);

    void deleteByImdbEquals(String imdb);
}
