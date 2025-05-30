package com.toDoListModel;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		String email=req.getParameter("email");
		String name= req.getParameter("name");
		
		String caste = req.getParameter("caste");
		
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("cfmPassword");
		
		String dob = req.getParameter("dob");
		
		Date birthday = Date.valueOf(dob);
		TasksEntity entity = new TasksEntity();
		
		if (password.length()>=8) {
			if (password.equals(confirmPassword)) {
				User user = new User();
				user.setName(name);
				user.setCaste(caste);
				user.setEmail(email);
				user.setPassword(password);
				user.setDate(birthday);
				
				user.getTasks().add(entity);
				entity.setUser(user);
				
				Configuration cfg = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(TasksEntity.class).configure();
				
				SessionFactory sf= cfg.buildSessionFactory();
				
				Session session = sf.openSession();
				session.beginTransaction();
				
				Query checkUser = session.createQuery("from User where email=:mail");
				checkUser.setParameter("mail", email);
				
			User seeUser = (User)checkUser.uniqueResult();				
			if (seeUser!=null) {
				try {
					res.sendRedirect("TaskCondition.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}	else {
			
			
				session.save(user);
				session.getTransaction().commit();
				session.close();
				
				try {
					res.sendRedirect("Login.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}else {
				try {
					
				res.sendRedirect("Registration.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			
		}else {
			try {
			res.sendRedirect("Registration.jsp");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}
