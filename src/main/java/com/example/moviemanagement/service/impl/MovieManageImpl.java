package com.example.moviemanagement.service.impl;

import com.example.moviemanagement.dto.MovieDto;
import com.example.moviemanagement.dto.ResponseDto;
import com.example.moviemanagement.entity.Movie;
import com.example.moviemanagement.repository.ManagerRepo;
import com.example.moviemanagement.service.MovieManage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieManageImpl implements MovieManage {
    private final ManagerRepo managerRepo;
    private final ModelMapper modelMapper;
    @Override
    public ResponseDto addMovie(MovieDto movieDto) {
       if (managerRepo.existsByImdb(movieDto.getImdb())){
          return new ResponseDto("04",
                  "Movie Already Exists",
                  null);
       }
       managerRepo.save(modelMapper.map(movieDto, Movie.class));
       return new ResponseDto("00",
               "Success",
               null);
    }
}
