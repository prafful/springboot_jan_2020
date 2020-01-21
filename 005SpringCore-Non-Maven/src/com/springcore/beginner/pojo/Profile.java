package com.springcore.beginner.pojo;

public class Profile {
	int likes;
	String status;
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Profile(int likes, String status) {
		super();
		this.likes = likes;
		this.status = status;
	}
	public Profile() {
		super();
		
	}
	
	
}
