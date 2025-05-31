package com.toDoListModel;
import java.sql.Date;
import java.util.Iterator;
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

@WebServlet("/updateTasks")
public class updateTask extends HttpServlet {

	public void doGet(HttpServletRequest req , HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		Configuration cfg = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(TasksEntity.class).configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		session.beginTransaction();
	TasksEntity result=	session.get(TasksEntity.class, id);

	session.getTransaction().commit();
 		if (result!=null) {
 			try {
 			HttpSession httpSession = req.getSession();
 			httpSession.setAttribute("result", result);
 			res.sendRedirect("updateTask.jsp?id="+id);
 			
 			}catch (Exception e) {
				// TODO: handle exception
 				
 				System.out.println(e.getMessage());
			}
 			
		}else {
			try {
				res.getWriter().print("the data is not present in the database please store the data in the database");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
}
	
	
}
