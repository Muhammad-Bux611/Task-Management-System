package com.toDoListModel;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteTasks")
public class deleteTask extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

//		HttpSession httpSession = req.getSession();
//	String email	=(String)httpSession.getAttribute("mail");
		
		String id = req.getParameter("id");
		
			Configuration cfg = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(TasksEntity.class).configure();
			
			SessionFactory sf = cfg.buildSessionFactory();
			
			Session session = sf.openSession();
			session.beginTransaction();
			
			TasksEntity task = session.get(TasksEntity.class, id);
			
			if (task==null) {
				try {
					res.sendRedirect("Tasks.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}else
				{
				session.remove(task);
				try {
					res.sendRedirect("SeeTask?email="+task.getUser().email);
					
//					res.sendRedirect("viewTasks.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
				}
				
			
			session.getTransaction().commit();
			
			
 		}
	}

