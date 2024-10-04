package com.ssafy.schedule.model.dto;

import java.io.Serializable;

public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static int no = 1;
	private int id;
	private String date;
	private String content;
	private String semicontent;
	private String today_luck;
	
	public String getToday_luck() {
		return today_luck;
	}

	public void setToday_luck(String today_luck) {
		this.today_luck = today_luck;
	}

	public Schedule() {
	}

	public Schedule(String date, String content, String semicontent, String today_luck) {
		this.id = no++;
		this.date = date;
		this.content = content;
		this.semicontent = semicontent;
		this.today_luck = today_luck;
	}

	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Schedule.no = no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSemicontent() {
		return semicontent;
	}

	public void setSemicontent(String semicontent) {
		this.semicontent = semicontent;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", content=" + content + ", semicontent=" + semicontent + "]";
	}
	
	
	
}
