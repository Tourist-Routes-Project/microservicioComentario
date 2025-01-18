package com.project.comment.persistance.models;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name ="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comment")
	private int commentId;
	
	@Column(name="id_user", nullable = false)
	private int userId;
	
	@Column(name="id_route", nullable = false)
	private int routeId;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "created_date")
    private Date createdDate;

}
