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

@WebServlet("/EditTasks")
public class EditTask extends HttpServlet  {

	public void doPost(HttpServletRequest req , HttpServletResponse res) {
		
		String title = req.getParameter("title");
		String discription = req.getParameter("discription");
		String due = req.getParameter("due");
		Date date  = Date.valueOf(due);
	
		int id = Integer.parseInt(req.getParameter("id"));
		Configuration cfg = new Configuration().addAnnotatedClass(TasksEntity.class).addAnnotatedClass(User.class).configure();
	
		SessionFactory sf = cfg.buildSessionFactory();
	
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		TasksEntity task = session.get(TasksEntity.class, id);
		if (task!=null) {
			String hql= "update TasksEntity t  set t.title=:newTitle, t.discription =:disc, t.dueDate =:due  where t.id=:id ";

			Query updateTask = session.createQuery(hql);
			updateTask.setParameter("newTitle", title);
			updateTask.setParameter("disc", discription);
			updateTask.setParameter("due", date);
			updateTask.setParameter("id", id);
			
			Session checkDueDate = sf.openSession();
			checkDueDate.beginTransaction();
			
			String sql = "select current_date()";
			Query system_Date = checkDueDate.createQuery(sql);
			
			Date sys_date =(Date)system_Date.uniqueResult();
			checkDueDate.getTransaction().commit();
			
			if (sys_date.after(date)) {
				
				Session s = sf.openSession();
				s.beginTransaction();
				
				Query q =  s.createQuery("from TasksEntity where id=:id");
				q.setParameter("id", task.id);
				
				TasksEntity entities = (TasksEntity)q.uniqueResult();
				s.getTransaction().commit();
				if (entities==null) {
					try {
						res.sendRedirect("Tasks.jsp");
					}catch (Exception e) {
						// TODO: handle exception
					}
				}else
				{
					HttpSession fetchSession = req.getSession();
					
				try {	
					res.sendRedirect("SeeTask?email="+entities.getUser().email);
					
					
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}else {
			
			
			int i =	updateTask.executeUpdate();
			session.getTransaction().commit();
			
			Session session2 =sf.openSession();
			session2.beginTransaction();
			
			String seeData = "from TasksEntity where user.email=:mail";
			Query seeDataQuery = session2.createQuery(seeData);
			seeDataQuery.setParameter("mail", task.getUser().email);
			
			List<TasksEntity> tasks = seeDataQuery.list();
			
			session2.getTransaction().commit();
			if (tasks.size()==0) {
				try {
				res.sendRedirect("Tasks.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}else {
			
				HttpSession httpSession = req.getSession();
				
			if (i>0) {
				try {
					
					res.sendRedirect("SeeTask?email="+task.getUser().email);
				}catch (Exception e) {
					// TODO: handle exception
				}

			}else {
				System.out.println("something went to wrong");
			}

			
			}
			}
		}else {
			try {
				res.getWriter().print("the data is not present in the database");
			}catch (Exception e) {
				// TODO: handle exception

System.out.println(e.getMessage());
			}
			
		}
		
	}
	
 	}	
	

	
