package com.toDoListModel;
import java.sql.Date;

import javax.annotation.processing.Generated;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class TasksEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ;
	


	String title;
	String discription;
	
	
	Date dueDate;
	
	
	
	@ManyToOne

	@JoinColumn(name = "email")
	User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	@Override
	public String toString() {
		return "TasksEntity [title=" + title + ", discription=" + discription + ", dueDate=" + dueDate + "]";
	}
	
	
}

