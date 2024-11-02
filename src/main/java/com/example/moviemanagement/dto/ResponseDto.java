package com.example.moviemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String responseCode;
    private String responseMsg;
    private List<MovieDto> content;
}
