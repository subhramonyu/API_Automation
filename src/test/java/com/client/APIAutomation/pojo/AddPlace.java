package com.client.APIAutomation.pojo;

public class AddPlace {
	private String name ;
	private String job;
	private String createdAt;
	private int id;
	
	public AddPlace(){
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
