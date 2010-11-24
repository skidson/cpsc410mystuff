package ca.ubc.cpsc.mystuff.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.ubc.cpsc.mystuff.model.UserBean;

public class LoginServlet extends HttpServlet {
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {	    
		     UserBean user = new UserBean();
		     user.setUsername(request.getParameter("username"));
		     user.setPassword(request.getParameter("password"));

		     user = UserDAO.login(user);
			   		    
		     if (user.isValid()) {
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",user); 
		          response.sendRedirect("index.html"); //logged-in page      		
		     } else 
		          response.sendRedirect("login.jsp"); //error page 
		} catch (Exception e) {
		     e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		this.doGet(request, response);
	}*/
}
