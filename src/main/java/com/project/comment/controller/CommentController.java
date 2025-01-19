package com.project.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comment.persistance.models.Comment;
import com.project.comment.persistance.models.Response;
import com.project.comment.services.CommentServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CommentController {
	
	@Autowired
	private CommentServiceI commentService;
	
	@PostMapping("/comment")
	public ResponseEntity<Response<Comment>> addCommnet (@Valid @RequestBody Comment comment){
		return commentService.addComment(comment);
	}
	
	@PutMapping("/comment/{id}")
	public ResponseEntity<Response<Comment>> updateCommnet (@PathVariable int id, @RequestBody Comment updateComment){
		return commentService.updateComment(id, updateComment);
	}
	
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<Response<Comment>> deleteComment (@PathVariable int id){
		return commentService.deleteComment(id);
	}

}
