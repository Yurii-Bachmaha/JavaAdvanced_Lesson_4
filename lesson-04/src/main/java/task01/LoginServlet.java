package task01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = UserService.getUserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.getUser(login);
		
		if(user == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if(user.getPassword().equals(password)) {
			request.setAttribute("userFirstName", user.getFirstName());
			request.setAttribute("userLastName", user.getLastName());
			request.setAttribute("userAction", "logged in to");
			
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		}
	}

}