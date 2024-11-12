package com.ssafy.ws.model.dto;

public class SearchCondition {
	private String title;
	private String content = "none";
	private String order;
	private String direction;
	
	public SearchCondition() {
	}
	
	public SearchCondition(String title, String content, String order, String direction) {
		this.title = title;
		this.content = content;
		this.order = order;
		this.direction = direction;
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
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "SearchCondition [title=" + title + ", content=" + content + ", order=" + order + ", direction="
				+ direction + "]";
	}
}
