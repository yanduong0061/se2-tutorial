package servlet;
import java.util.List;


import dao.BookImp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String path = request.getServletPath();
		try {
			switch(path) {
			case "/newInsertBookForm":
				
					newInsertBookForm(request, response);
				break;
			case "/showUpdateBookForm":
				newUpdateBookForm(request, response);
				break;
			case "/insertBook":
				insertBook(request, response);
				break;
			case "/updateBook":
				updateBook(request, response);
				break;
			case "/deleteBook":
				deleteBook(request, response);
				break;
			default:
				displayBooks(request, response);
			
			}
		} catch(SQLException e) {
		e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String inputPrice = request.getParameter("price");
		String message = "";
		String mess = "";
		if(name.trim().equals("") || author.trim().equals("") || inputPrice.trim().equals("")) {
			message += "Action failed! All field are required!";
		} else if(bookImp.checkNumber(inputPrice) == false) {
			message += "Action failed! The price need to be number!";
		} else if(bookImp.checkBook(name) == true) {
			message += "Action failed! The book is already existed!";
		} else {
			double price = Double.parseDouble(inputPrice);
			if(bookImp.insertBook(new Book(name, author, price)) == true) {
				 mess += "Add book successfully!";
				
			} else {
				mess += "Add book failed!";
			}
			 HttpSession session = request.getSession();
			 session.setAttribute("mess", mess);
			
			response.sendRedirect("book-list");
			
		}
		if(message.length() > 0) {
			request.setAttribute("message", message);
			request.getRequestDispatcher("book_form.jsp").forward(request, response);
		}
		
	}
	
	
	private void displayBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		List<Book> books = bookImp.getAllBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("book-list.jsp").forward(request, response);
		
	}
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String inputPrice = request.getParameter("price");
		String message = "";
		String mess = "";
		HttpSession session = request.getSession();
		if(name.trim().equals("") || author.trim().equals("") || inputPrice.trim().equals("")) {
			message += "Action failed! All field are required!";
		} else if(bookImp.checkNumber(inputPrice) == false) {
			message += "Action failed! The price need to be number!";
		
		} else {
		double price = Double.parseDouble(inputPrice);
		Book book = new Book(id, name, author, price);
		boolean updated = bookImp.updateBook(book);
		if(updated) {
			mess += "Update book successfully!";
		} else {
			mess += "Update book failed!";
		}
		session.setAttribute("mess", mess);
		response.sendRedirect("book-list");
		session.removeAttribute(mess);
		
		}
		if(message.length() > 0) {
			request.setAttribute("message", message);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
	}
	
	private void newInsertBookForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		request.getRequestDispatcher("book_form.jsp").forward(request, response);
	}
	private void newUpdateBookForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookImp.getBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book_form.jsp");
		request.setAttribute("book", book);
		dispatcher.forward(request, response);
		
	}
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean done = bookImp.deleteBook(id);
		HttpSession session = request.getSession();
		String mess = "";
		if(done) {
			mess += "Delete book successfully!";
			
			
		} else {
			mess += "Delete book failed!";
		}
		session.setAttribute("mess", mess);
		response.sendRedirect("book-list");
			
		
		
		
	}

}
