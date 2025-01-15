package com.project.comment.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.comment.persistance.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
