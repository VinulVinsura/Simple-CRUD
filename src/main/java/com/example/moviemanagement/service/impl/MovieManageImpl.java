package com.example.moviemanagement.service.impl;

import com.example.moviemanagement.dto.MovieDto;
import com.example.moviemanagement.dto.ResponseDto;
import com.example.moviemanagement.entity.Movie;
import com.example.moviemanagement.repository.ManagerRepo;
import com.example.moviemanagement.service.MovieManage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ResponseDto getAllMovies() {
        List<Movie> movieList = managerRepo.findAll();
        if (movieList.isEmpty()){
            return new ResponseDto("02",
                    "No Movies Found",
                     null);
        }
        return  new ResponseDto("00",
                "Success",
                modelMapper.map(movieList,new TypeToken<List<MovieDto>>(){}.getType()));
    }

    @Override
    public ResponseDto getMovieByImdb(String imdb) {
        List<Movie> movieList = managerRepo.findByImdb(imdb);
        if (movieList.isEmpty()){
            return new ResponseDto("02",
                    "No Such Movie Found",
                    null);

        }
        return new ResponseDto("00",
                "Success",
                modelMapper.map(movieList,new TypeToken<List<MovieDto>>(){}.getType()));

    }

    @Override
    public ResponseDto deleteMovie(String imdb) {
        if (managerRepo.existsByImdb(imdb)){
            managerRepo.deleteAllByImdb(imdb);
            return new ResponseDto("00",
                    "Success",
                    null);
        }
        return new ResponseDto("02",
                "No Such Movie Exists",
                null);
    }
}
