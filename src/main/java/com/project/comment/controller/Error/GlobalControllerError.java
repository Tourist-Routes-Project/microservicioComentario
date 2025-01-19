package com.project.comment.controller.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.comment.exceptions.ExceptionInvalidCommentData;
import com.project.comment.exceptions.ExceptionNotFoundComment;
import com.project.comment.persistance.models.ApiError;

@RestControllerAdvice
public class GlobalControllerError {
	
		//Maneja la excepción cuando los datos del comentario no son válidos
		 @ExceptionHandler(ExceptionInvalidCommentData.class)
		 public ResponseEntity<ApiError> invalidCommentData(ExceptionInvalidCommentData e) {
		     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getMessage());
		     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
		}
		 
		// Maneja la excepción cuando no se encuentra un comentario
		 @ExceptionHandler(ExceptionNotFoundComment.class)
		 public ResponseEntity<ApiError> commentNotFoundException(ExceptionNotFoundComment e) {
		      ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
		      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		 }

}
