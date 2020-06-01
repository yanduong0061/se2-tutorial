package servlet;
import java.util.List;
import dao.BookImp;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	  BookImp bookImp;
	private static final long serialVersionUID = 1L;
       public void init() {
    	  bookImp = new BookImp();
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
		// TODO Auto-generated method stub
		try {
			displayBooks(request, response);
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
	private void displayBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		List<Book> books = bookImp.getAllBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("book-list.jsp").forward(request, response);
		
	}

}
