package com.example.moviemanagement.service.impl;

import com.example.moviemanagement.dto.MovieDto;
import com.example.moviemanagement.dto.ResponseDto;
import com.example.moviemanagement.entity.Movie;
import com.example.moviemanagement.exceptions.BadRequestException;
import com.example.moviemanagement.repository.ManagerRepo;
import com.example.moviemanagement.service.MovieManage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieManageImpl implements MovieManage {
    private final ManagerRepo managerRepo;
    private final ModelMapper modelMapper;
    @Override
    public ResponseDto addMovie(MovieDto movieDto) {
        try {
            if (managerRepo.existsByImdb(movieDto.getImdb())){
                return new ResponseDto("04",
                        "Movie Already Exists",
                        null);
            }
            managerRepo.save(modelMapper.map(movieDto, Movie.class));
            return new ResponseDto("00",
                    "Success",
                    null);
        }catch (Exception ex){
            throw new BadRequestException();
        }
        }


    @Override
    public ResponseDto getAllMovies() {
        try {
            List<Movie> movieList = managerRepo.findAll();
            if (movieList.isEmpty()){
                return new ResponseDto("02",
                        "No Movies Found",
                        null);
            }
            return  new ResponseDto("00",
                    "Success",
                    modelMapper.map(movieList,new TypeToken<List<MovieDto>>(){}.getType()));

        }catch (BadRequestException ex){
            throw new BadRequestException();
        }

    }

    @Override
    public ResponseDto getMovieByImdb(String imdb) {
        try {
            List<Movie> movieList = managerRepo.findByImdb(imdb);
            if (movieList.isEmpty()){
                return new ResponseDto("02",
                        "No Such Movie Found",
                        null);

            }
            return new ResponseDto("00",
                    "Success",
                    modelMapper.map(movieList,new TypeToken<List<MovieDto>>(){}.getType()));


        }catch (BadRequestException ex){
            throw  new BadRequestException();
        }

    }

    @Override
    public ResponseDto deleteMovie(String imdb) {
        try {
            Optional<Movie> movie = managerRepo.findByImdbEquals(imdb);
            if (movie.isPresent()){
                managerRepo.deleteByImdbEquals(imdb);
                return new ResponseDto("00",
                        "Success",
                        null);
            }else {
                return new ResponseDto("02",
                        "No Such Movie Exists",
                        null);
            }

        }catch (Exception e){
            log.error("Bad Request");
            throw new BadRequestException();
        }


    }
}
