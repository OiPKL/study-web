package com.ssafy.model.dto;

import java.time.LocalDateTime;

public class Article {
	
	private int id;
	private String title;
	private String content;
	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public Article() {
		
	}
	
	public Article(int id, String title, String content, LocalDateTime created_at, LocalDateTime updated_at) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
}
