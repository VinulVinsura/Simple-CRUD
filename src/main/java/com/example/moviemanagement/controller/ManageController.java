package com.example.moviemanagement.controller;

import com.example.moviemanagement.dto.MovieDto;
import com.example.moviemanagement.dto.ResponseDto;
import com.example.moviemanagement.service.MovieManage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@RequiredArgsConstructor
public class ManageController {
    private final MovieManage manageService;

    @PostMapping("/movies")
    public ResponseEntity<ResponseDto> addMovie(@RequestBody MovieDto movieDto){

        return ResponseEntity.ok(manageService.addMovie(movieDto));
    }
}
