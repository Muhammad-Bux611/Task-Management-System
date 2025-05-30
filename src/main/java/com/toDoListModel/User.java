package com.toDoListModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	
	String email;
	
	String name;
	String caste;
	String password;
	
	Date date;
	
	@OneToMany(mappedBy = "user")
	List<TasksEntity> tasks = new ArrayList<TasksEntity>();
	

	public List<TasksEntity> getTasks() {
		return tasks;
	}

	public void setTasks(List<TasksEntity> tasks) {
		this.tasks = tasks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", caste=" + caste + ", password=" + password + ", date="
				+ date + "]";
	}
	
	
}
