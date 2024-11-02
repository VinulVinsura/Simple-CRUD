package com.example.moviemanagement.service;

import com.example.moviemanagement.dto.MovieDto;
import com.example.moviemanagement.dto.ResponseDto;

import java.util.List;

public interface MovieManage {
    ResponseDto addMovie(MovieDto movieDto);
    ResponseDto getAllMovies();
}
