package com.footprint.model;


/**
 * Model Student
 * 
 * @author footprint
 *
 */
public class Student {

	private int id;
	private String username;
	private String password;
	private long regDate;

	public Student() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRegDate() {
		return regDate;
	}

	public void setRegDate(long regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", password=" + password + ", regDate=" + regDate + "]";
	}

}
