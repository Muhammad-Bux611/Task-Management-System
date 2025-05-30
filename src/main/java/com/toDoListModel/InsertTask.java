package com.toDoListModel;

import java.sql.Date;
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

@WebServlet("/InsertTask")
public class InsertTask extends HttpServlet {
	TasksEntity entity = new TasksEntity();
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		
		
		String title = req.getParameter("title");
		
		String discription  = req.getParameter("discription");
		Date dueDate;
		
		HttpSession httpSession = req.getSession();
		
		String email = (String)httpSession.getAttribute("email");
		
//		String email = (String) httpSession.getAttribute("email");

		if (email == null || email.trim().isEmpty()) {
		    try {
		        res.sendRedirect("Login.jsp");
		        return;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return;
		    }
		}

		
		String due = req.getParameter("due");

		Date sqlDate = null;
		if (due != null && !due.trim().isEmpty()) {
		    sqlDate = Date.valueOf(due);
		} else {

			try {
		    res.getWriter().println("Error: Due date is missing or invalid.");
		    return;
			}catch (Exception e) {
				// TODO: handle exception
			}
		    
		}

		
		entity.setDiscription(discription);
		entity.setDueDate(sqlDate);

		User user = new User();
//		user.setEmail(email);
		int count =0;
			Configuration config= new Configuration().addAnnotatedClass(TasksEntity.class).addAnnotatedClass(User.class).configure();
			
			
			SessionFactory sf = config.buildSessionFactory();
			
			Session  session = sf.openSession();
			
			session.beginTransaction();
			
		  user = session.get(User.class,email);
		  String getData = "from TasksEntity t where  t.title=:Title";
		  Query fetchData = session.createQuery(getData);
		  fetchData.setParameter("Title", title);
//		  fetchData.setParameter("mail", email);
			List<TasksEntity> entities =(List<TasksEntity>) fetchData.list();
			entity.setUser(user);
			
			
			entity.setTitle(title);
			
			
			Session dateSession = sf.openSession();
			String date_Query = "Select current_date()";
			dateSession.beginTransaction();
			Query curr_Date = session.createQuery(date_Query);
		Date date=(Date)curr_Date.uniqueResult();
//		Date date = Date.valueOf(sys_Date);
		dateSession.getTransaction().commit();
			
		if (user==null) {
			try {
				
				res.sendRedirect("Login.jsp");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		
		
		 if (entities.size()!=0) {
			
		
			
			for (TasksEntity tasksEntity : entities) {
				
				if (tasksEntity.getUser().email.equals(email)) {
					System.out.println("this task is already stored by :"+email);
					count++;
					try {
				res.sendRedirect("Tasks.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
				}
				count++;
				 if (count==entities.size()-1) {
					break;
				}
			}
			if (count==entities.size()) {
				if (entities.getLast().getUser().email.equals(email) ) {
					try {
					res.sendRedirect("Tasks.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
				}

				else {
				if (date.before(sqlDate) || date.equals(sqlDate)) {
					
				

					HttpSession viewHttpSession;
					List<TasksEntity> viewTasks=null;
				session.save(entity);
				session.getTransaction().commit();
				
				System.out.println("the data is successfully added");
			
			
			try {
//				Session viewSession = sf.openSession();
//				viewSession.beginTransaction();
//				Query viewQuery = viewSession.createQuery("from TasksEntity where user.email=:mail");
//				 viewTasks = viewQuery.list();
//				 viewHttpSession = req.getSession();
//				viewHttpSession.setAttribute("view", viewTasks);
//				res.sendRedirect("viewTasks.jsp");
//				viewSession.getTransaction().commit();
				
				res.sendRedirect("SeeTask?email="+email);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		
				}
				else {
					try {
						res.getWriter().print("incorrect data");
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
				}
			
			
			}
			
		}
		 else {
			if (date.before(sqlDate) || date.equals(sqlDate)) {
				
			
			Session session2 =sf.openSession();
		session2.beginTransaction();
		session2.save(entity);
		session2.getTransaction().commit();
		try {
			
//			Session checkSession = sf.openSession();
//			checkSession.beginTransaction();
//			Query q = checkSession.createQuery("from TasksEntity where user.email=:mail");
//			q.setParameter("mail", email);
//			List<TasksEntity> checkList = q.list();
//		httpSession.setAttribute("view",checkList );
		httpSession.setAttribute("sys_Date", date);
//		checkSession.getTransaction().commit();
//		res.sendRedirect("viewTasks.jsp");
		
		res.sendRedirect("SeeTask?email="+email);
		}catch (Exception e) {
			// TODO: handle exception
		}
		 }else {
			 try {
				 res.getWriter().print("the data is not stored due to some reason");
			 }catch (Exception e) {
				// TODO: handle exception
			}
		 }
		 }
					
	}
}
	