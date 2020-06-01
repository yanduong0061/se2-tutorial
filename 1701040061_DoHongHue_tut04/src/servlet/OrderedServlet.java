package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		try {
			displayOrdereds(request, response);
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
}
