package com.springmvc.domain;

public class Project {
	private String name; //������Ʈ �̸�
	private String content; // ������Ʈ �� ����
	
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
