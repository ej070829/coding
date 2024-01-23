package com.springmvc.domain;

public class Project {
	private String name; //프로젝트 이름
	private String content; // 프로젝트 상세 내용
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Project(String name) {
		super();
		this.name = name;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

}
