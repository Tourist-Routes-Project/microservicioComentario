package com.project.comment.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.comment.persistance.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	Optional<Comment> findByCommentId (int commentId);

}
