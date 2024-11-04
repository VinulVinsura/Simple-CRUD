package com.example.moviemanagement.exceptions;

import com.example.moviemanagement.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class )
    public ResponseEntity<ResponseDto> handleAccessDeniedException(BadRequestException e, WebRequest request){
        ResponseDto responseDto = new ResponseDto("06","Bad Request",null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }
}
