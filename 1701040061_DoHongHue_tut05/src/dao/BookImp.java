package dao;
import model.Book;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class BookImp implements BookDAO {
	
public BookImp() {
	
}

public Book getBook(int id) {
	
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	Book book = null;
	try {
		ps = conn.prepareStatement("select * from book where bookId = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			 book = new Book(id, name, author, price);
		}
		
		
	}catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
	} finally {
		if(ps != null) {
			try {
				ps.close();
			} catch(SQLException e) {
				
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {}
		}
		
}
	
	return book;
}
public boolean insertBook(Book book) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
boolean isInserted = false;
	try {
		ps = conn.prepareStatement("insert into book (name, author, price) values(?,?,?)");
		ps.setString(1, book.getName());
		ps.setString(2, book.getAuthor());
		ps.setDouble(3, book.getPrice());
		 int row = ps.executeUpdate();
		 isInserted = row > 0;
		
		
		
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
	} finally {
		if(ps != null) {
			try {
				ps.close();
			} catch(SQLException e) {
				
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {}
		}
	}
	return isInserted;
}

public boolean updateBook(Book book) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean isUpdated = false;
	try {
		ps = conn.prepareStatement("update book set name = ?, author = ?, price = ? where bookId = ?");
		ps.setString(1, book.getName());
		ps.setString(2, book.getAuthor());
		ps.setDouble(3, book.getPrice());
		ps.setInt(4, book.getBookId());
		int row = ps.executeUpdate();
		isUpdated = row > 0;
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
	}  finally {
		if(ps != null) {
			try {
				ps.close();
			} catch(SQLException e) {
				
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {}
		}
	}
	return isUpdated;
}

public boolean deleteBook(int id) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean isDeleted = false;
	try {
		ps = conn.prepareStatement("delete from book where bookId = ?");
		ps.setInt(1, id);
		int row = ps.executeUpdate();
		isDeleted = row > 0;
		
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
	}  finally {
		if(ps != null) {
			try {
				ps.close();
			} catch(SQLException e) {
				
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {}
		}
	}
	return isDeleted;
}
public List<Book> getAllBooks() {
	List<Book> books = new ArrayList<>();
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	String sql = "select * from book";
	try {
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("bookId");
			String name = rs.getString("name");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			Book b = new Book(id, name, author, price);
			books.add(b);
		}
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		if(ps != null) {
			try {
				ps.close();
			} catch(SQLException e) {
				
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {}
		}
	}
	return books;
}

public boolean checkNumber(String input) {
	try {
	Double.parseDouble(input);
		return true;
	} catch(NumberFormatException e) {
	e.printStackTrace();
	return false;
	}
}

public boolean checkBook(String name) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	try {
		ps = conn.prepareStatement("select * from book where name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		} 
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
	} finally {
		if(ps != null) {
			try {
				ps.close();
			} catch(SQLException e) {
				
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {}
		}
	}
	return false;
}
}
