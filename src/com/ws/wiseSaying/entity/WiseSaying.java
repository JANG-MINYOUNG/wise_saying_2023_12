package com.ws.wiseSaying.entity;

public class WiseSaying {
	private int id; // int type 만 넣을 수 있는 변수 id 만듬
	private String content; // String type 만 넣을 수 있는 변수 content 만듬
	private String author; // String type 만 넣을 수 있는 변수 author 만듬

	public WiseSaying(int id, String content, String author) { 
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}