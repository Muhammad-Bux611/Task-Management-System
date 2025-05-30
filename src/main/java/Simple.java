//import javax.servlet.annotation.WebServlet;
import javax.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Simple")
public class Simple extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String dueDate = req.getParameter("due");

            res.setContentType("text/html");
            res.getWriter().println("Title: " + title + "<br>");
            res.getWriter().println("Description: " + description + "<br>");
            res.getWriter().println("Due Date: " + dueDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
