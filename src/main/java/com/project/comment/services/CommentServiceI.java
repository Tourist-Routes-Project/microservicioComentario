package com.project.comment.services;

import org.springframework.http.ResponseEntity;

import com.project.comment.persistance.models.Comment;
import com.project.comment.persistance.models.Response;

public interface CommentServiceI {
	
	//Método para agregar un comentario, devolviendo un ResponseEntity
	ResponseEntity<Response<Comment>> addComment (Comment comment);

}
