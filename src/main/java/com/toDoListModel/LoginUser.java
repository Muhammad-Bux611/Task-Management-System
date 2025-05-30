package com.toDoListModel;
import java.util.List;
//
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
//
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		String email = req.getParameter("mail");
		
		String password = req.getParameter("password");
		
		Configuration cfn  = new Configuration().addAnnotatedClass(TasksEntity.class).addAnnotatedClass(User.class).configure();
		
		SessionFactory sf = cfn.buildSessionFactory();
		
		Session session= sf.openSession();
		
	HttpSession httpSession=	req.getSession();
		
		Query query = session.createQuery("select email , password from User");
	List<Object[]> users=query.list();
	if (users.size()==0) {
		try {
		res.sendRedirect("Registration.jsp");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}else {
		for (Object[] objects : users) {
			if (objects[0].equals(email) && objects[1].equals(password)) {
				try {
					httpSession.setAttribute("email", objects[0]);
				res.sendRedirect("TaskCondition.jsp");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
	}
	
	
	}
	
}