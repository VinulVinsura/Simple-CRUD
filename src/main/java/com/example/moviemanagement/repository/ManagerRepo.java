package com.example.moviemanagement.repository;

import com.example.moviemanagement.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Movie,Long> {

    boolean existsByImdb(String imdb);
}
