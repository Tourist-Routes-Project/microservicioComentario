package com.project.comment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.comment.exceptions.ExceptionInvalidCommentData;
import com.project.comment.exceptions.ExceptionNotFoundComment;
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
			comment.setRouteId(4); //De forman provisional asignamos el id a una de las varias rutas creadas
			comment.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
			commentRepository.save(comment);
			
			Response<Comment> response = new Response<>(HttpStatus.CREATED, "Comment saved correctly");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        // Manejar excepciones
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage()));
	    }
	}

	@Override
	public ResponseEntity<Response<Comment>> updateComment(int id, Comment comment) {
		
		Optional<Comment> optionalComment = commentRepository.findByCommentId(id);
		
		if(!optionalComment.isPresent()) {
			throw new ExceptionNotFoundComment("Comment not found");
		}
		
		try {
			
			Comment updateComment = optionalComment.get();
			
			updateComment.setUserId(1); //Volvemos a ajustar el id del usuario al comentario 
			updateComment.setRouteId(4); //volvemos a ajustar el id de la ruta al comentario
			
			if(comment.getDescription()==null || comment.getDescription().isEmpty()) {
				throw new ExceptionInvalidCommentData("The description cannot be null");
			}
			updateComment.setDescription(comment.getDescription());
			updateComment.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
			
			commentRepository.save(updateComment);
			
	        // Se almacena una respuesta estructurada de la clase Response
	        Response<Comment> response = new Response<>(HttpStatus.OK, "Comment updated successfully");
	        return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (Exception e) {
	        // Manejar excepciones
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage()));
	    }
	}

	@Override
	public ResponseEntity<Response<Comment>> deleteComment(int id) {
		

		Optional<Comment> optionalComment = commentRepository.findByCommentId(id);
		
		if(!optionalComment.isPresent()) {
			throw new ExceptionNotFoundComment("Comment not found");
		}
		
		Comment deleteComment = optionalComment.get();
		
		try {
			//Se llama al repositorio para proceder a eliminar el comentario
			commentRepository.delete(deleteComment);		
			//Se almacena una respuesta estructurada de la clase Reponse.
			Response<Comment> response = new Response<>(HttpStatus.OK, "Comment delete correctly");
			// Se devuelve una respuesta indicando que se ha eliminado
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		}catch (Exception e) {
			// Manejar excepciones
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage()));
	    }
	}

}
