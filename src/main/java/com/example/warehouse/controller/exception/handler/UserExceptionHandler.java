package com.example.warehouse.controller.exception.handler;

import com.example.warehouse.dto.wrapper.ErrorResponse;
import com.example.warehouse.exception.userhandler.UserNotFoundByIdException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@AllArgsConstructor
@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse>handlingUserNoFoundByIdError(UserNotFoundByIdException ex){
       ErrorResponse er= new ErrorResponse(HttpStatus.NOT_FOUND.value(),"User Not found BY This Id");
      return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
    }
}
