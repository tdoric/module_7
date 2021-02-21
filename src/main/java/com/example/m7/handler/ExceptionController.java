package com.example.m7.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.m7.exception.ErrorExc;
import com.example.m7.response.AddToGroupResponse;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler({ ErrorExc.class })
    public ResponseEntity<AddToGroupResponse>  handleException(ErrorExc exc) {
		return ResponseEntity
				.badRequest()
				.body(new AddToGroupResponse(exc.getMessage()));
    }

}


