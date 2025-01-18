package com.project.comment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.comment.exceptions.ExceptionInvalidCommentData;
import com.project.comment.persistance.models.Comment;
import com.project.comment.persistance.models.Response;
import com.project.comment.persistance.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentServiceI{
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public ResponseEntity<Response<Comment>> addComment(Comment comment) {
		
		if(comment.getDescription() == null || comment.getDescription().isEmpty()) {
			throw new ExceptionInvalidCommentData("The description cannot be null");
		}
		
		try {	
			comment.setUserId(1); //De forma provisional asignamos el id al unico user
			comment.setRouteId(4);
			comment.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
			commentRepository.save(comment);
			
			Response<Comment> response = new Response<>(HttpStatus.CREATED, "Comment saved correctly");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        // Manejar excepciones
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage()));
	    }
	}

}
