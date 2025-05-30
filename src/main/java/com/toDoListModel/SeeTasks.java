package com.toDoListModel;
import java.io.PrintWriter;
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

@WebServlet("/SeeTask")
public class SeeTasks extends HttpServlet {
		public void service(HttpServletRequest req , HttpServletResponse res) {
			
			String email = req.getParameter("email");
			
			if (email==null) {
				try {
					res.sendRedirect("Login.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			else {
				Configuration cfg = new Configuration().addAnnotatedClass(User.class)
						.addAnnotatedClass(TasksEntity.class).configure();
			
				SessionFactory sf = cfg.buildSessionFactory();
				
			Session session = sf.openSession();
			
			session.beginTransaction();
			
			Query query = session.createQuery("from TasksEntity t where t.user.email=:mail");
			query.setParameter("mail", email);
			
			
			
			
			
		List<TasksEntity>	tasks =query.list();
		session.getTransaction().commit();

		HttpSession httpSession = req.getSession();
		
		if (tasks.size()==0) {
			try {
				res.sendRedirect("Tasks.jsp");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
		
		Session checkDueDate = sf.openSession();
		checkDueDate.beginTransaction();
		
		String sql = "select current_date()";
		Query system_Date = checkDueDate.createQuery(sql);
		
		Date sys_date =(Date)system_Date.uniqueResult();
		checkDueDate.getTransaction().commit();
		
		for (TasksEntity tasksEntity : tasks) {
			
			if (sys_date.after(tasksEntity.getDueDate())) {
				
				Session deletSession = sf.openSession();
				deletSession.beginTransaction();
				Query deleteQuery = deletSession.createQuery("delete from TasksEntity where dueDate=:due");
				deleteQuery.setParameter("due", tasksEntity.getDueDate());
				int i =deleteQuery.executeUpdate();
				deletSession.getTransaction().commit();
				if (i>0) {
				
				try {
					
				
				res.sendRedirect("viewTasks.jsp?email="+email);
				}catch (Exception e) {
					// TODO: handle exception
				}
				}
 				
			}
			
		}
		
		
		httpSession.setAttribute("view", tasks);
		httpSession.setAttribute("email", email);
		try {
			res.sendRedirect("viewTasks.jsp?email="+email);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			}			
		}
		}
}
