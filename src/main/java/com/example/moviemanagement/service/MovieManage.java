package com.example.moviemanagement.service;

import com.example.moviemanagement.dto.MovieDto;
import com.example.moviemanagement.dto.ResponseDto;

public interface MovieManage {
    ResponseDto addMovie(MovieDto movieDto);
}
