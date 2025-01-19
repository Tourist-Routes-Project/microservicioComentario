package com.project.comment.services;

import org.springframework.http.ResponseEntity;

import com.project.comment.persistance.models.Comment;
import com.project.comment.persistance.models.Response;

public interface CommentServiceI {
	
	//Método para agregar un comentario, devolviendo un ResponseEntity
	ResponseEntity<Response<Comment>> addComment (Comment comment);
	
	//Método para editar un comentario, devolviendo un ResponseEntity
	ResponseEntity<Response<Comment>> updateComment(int id, Comment updateComment);
	
	//Método para elimninar un comentario, devolviendo un ResponseEntity
	ResponseEntity<Response<Comment>> deleteComment (int id);

}
