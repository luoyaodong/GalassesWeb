package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_comments")
public class Comments {
	@Id
	@GeneratedValue
	private int id;
	private String comments;
	private int userId;
	private int glassesId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGlassesId() {
		return glassesId;
	}
	public void setGlassesId(int glassesId) {
		this.glassesId = glassesId;
	}
}
