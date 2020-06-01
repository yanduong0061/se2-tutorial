package servlet;
import model.User;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserImp;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserImp userImp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init() {
	userImp = new UserImp();
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
		
			switch(action) {
			case "/newInsertForm":
				newInsertForm(request, response);
				break;
			case "/newUpdateForm":
				newUpdateForm(request, response);
				break;
			case "/insertUser":
				insertUser(request, response);
				break;
			case "/updateUser":
				updateUser(request, response);
				break;
			case "/deleteUser":
				deleteUser(request, response);
				break;
			default:
				listUser(request, response);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	List<User> users = userImp.getAllUser();
	request.setAttribute("users", users);
	request.getRequestDispatcher("user-list.jsp").forward(request, response);
			
			
}

private void newInsertForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	request.getRequestDispatcher("user_form.jsp").forward(request, response);
}

private void newUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	User user = userImp.getUser(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
	request.setAttribute("user", user);
dispatcher.forward(request, response);
	
}

private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String phoneNumber = request.getParameter("phoneNumber");
	String message = "";
	String mess = "";
	if(name.trim().equals("") || address.trim().equals("") || phoneNumber.trim().equals("")) {
		message += "Action failed! All field are required!";
	} else {
			User u = new User(name, address, phoneNumber);
			boolean deleted = userImp.insertUser(u);
			if(deleted) {
				mess += "Add user successfully!";
			} else {
				mess += "Add user failed!";
			}
			HttpSession session = request.getSession();
			session.setAttribute("mess", mess);
			response.sendRedirect("user-list");
		}
	
		if(message.length() > 0) {
			request.setAttribute("message", message);
			request.getRequestDispatcher("user_form.jsp").forward(request, response);
		}
			
}

private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String phoneNumber = request.getParameter("phoneNumber");
	String message = "";
	String mess = "";
	if(name.trim().equals("") || address.trim().equals("") || phoneNumber.trim().equals("")) {
		message += "All field are required!";
	} else {
	User u = new User(id, name, address, phoneNumber);
	boolean updated = userImp.updateUser(u);
	if(updated) {
		mess += "Update user successfully!";
	} else {
		mess += "Update user failed!";
	}
	HttpSession session = request.getSession();
	session.setAttribute("mess", mess);
	response.sendRedirect("user-list");
	}
	if(message.length() > 0) {
		request.setAttribute("message", message);
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
 			
}

private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	String mess = "";
	boolean deleted = userImp.deleteUser(id);
	if(deleted) {
	mess += "Delete user successfully!";	
	} else {
		mess += "Delete user failed!";
	}
	HttpSession session = request.getSession();
	session.setAttribute("mess", mess);
	response.sendRedirect("user-list");
			
			
}



}
