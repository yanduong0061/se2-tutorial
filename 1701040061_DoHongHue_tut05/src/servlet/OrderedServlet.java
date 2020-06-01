package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Ordered;
import dao.OrderedImp;


@WebServlet("/OrderedServlet")
public class OrderedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderedImp orderedImp;
	
	
	public void init() {
		orderedImp = new OrderedImp();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		
		try {
			switch(path) {
			case "/newInsertOrderedForm":
				
				newInsertOrderedForm(request, response);
			break;
		case "/showUpdateOrderedForm":
			newUpdateOrderedForm(request, response);
			break;
		case "/insertOrdered":
			insertOrdered(request, response);
			break;
		case "/updateOrdered":
			updateOrdered(request, response);
			break;
		case "/deleteOrdered":
			deleteOrdered(request, response);
			break;
		default:
			displayOrdereds(request, response);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void displayOrdereds(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		List<Ordered> ordereds = orderedImp.getAllOrdered();
		request.setAttribute("ordereds", ordereds);
		request.getRequestDispatcher("ordered-list.jsp").forward(request, response);
		
	}
	
	
	private void insertOrdered(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		String input1 = request.getParameter("orderedAt");
		String input2 = request.getParameter("quantity");
		String input3 = request.getParameter("bookId");
		String input4 = request.getParameter("userId");
		String message = "";
		String mess = "";
		HttpSession session = request.getSession();
		
		if(input1.trim().equals("") || input2.trim().equals("") || input3.trim().equals("") || input4.trim().equals("")) {
			message += "Action failed! You need to enter all field!";
		} else if(orderedImp.checkNumber(input2, input3, input4) == false) {
			message += "Action failed! You need to enter number!";
		}	else if(orderedImp.validateDate(input1) == false) {
				message += "Add ordered failed!.  Date needs to be in the form of year-month-date and start from 2000!";
			
		} else {
			Date orderedAt = Date.valueOf(input1);
			
			int quantity = Integer.parseInt(input2);
			int bookId = Integer.parseInt(input3);
			int userId = Integer.parseInt(input4);
			boolean inserted = orderedImp.insertOrdered(new Ordered(orderedAt, quantity, bookId, userId));
			if(inserted) {
				mess += "Add ordered successfully!";
			} else {
				mess += "Add ordered failed!";
			}
			session.setAttribute("mess", mess);
			response.sendRedirect("ordered-list");
		}
		if(message.length() > 0) {
			request.setAttribute("message", message);
			request.getRequestDispatcher("ordered_form.jsp").forward(request, response);
		}
		
		
		
		
		
	}
	
	
	
	private void updateOrdered(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    String input1 = request.getParameter("orderedAt");
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String message = "";
		String mess = "";
		HttpSession session = request.getSession();
		if(orderedImp.validateDate(input1) == false) {
			message += "Update failed!. Date need to be in form of year-month-date and start from 2000!";
		} else {
			Date orderedAt = Date.valueOf(input1);
			Ordered ordered = new Ordered(id, orderedAt, quantity, bookId, userId);
			boolean updated = orderedImp.updateOrdered(ordered);
			if(updated) {
				mess += "Update ordered successfully!";
			} else {
				mess += "Update ordered failed!";
			}
			session.setAttribute("mess", mess);
			
			response.sendRedirect("ordered-list");
		}
		if(message.length() > 0) {
			request.setAttribute("message", message);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}
	
	private void newInsertOrderedForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		request.getRequestDispatcher("ordered_form.jsp").forward(request, response);
	}
	private void newUpdateOrderedForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		int id = Integer.parseInt(request.getParameter("id"));
		Ordered ordered = orderedImp.getOrdered(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ordered_form.jsp");
		request.setAttribute("ordered", ordered);
		dispatcher.forward(request, response);
		
	}
	private void deleteOrdered(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String mess = "";
		 boolean deleted = orderedImp.deleteOrdered(id);
		 if(deleted) {
			 mess += "Delete ordered successfully!";
		 } else {
			 mess += "Delete ordered failed!";
		 }
		 HttpSession session = request.getSession();
		 session.setAttribute("mess", mess);
		
			response.sendRedirect("ordered-list");
		
			
		
		
		
	}

}

