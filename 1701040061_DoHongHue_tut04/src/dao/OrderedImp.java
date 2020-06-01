package dao;


import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import model.Ordered;



public class OrderedImp implements OrderedDAO{
	
	public OrderedImp() {
		
	}
	public List<Ordered> getAllOrdered() {
		List<Ordered> ordereds = new ArrayList<>();
		Connection conn = DatabaseConnection.getConnection();
		String sql_all = "select * from ordered";
		PreparedStatement ps = null;
		try {
		ps = conn.prepareStatement(sql_all);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("orderedId");
			Date date = rs.getDate("orderedAt");
			int quantity= rs.getInt("quantity");
			int bookId = rs.getInt("bookId");
			int userId = rs.getInt("userId");
			
			Ordered o = new Ordered(id, date, quantity, bookId, userId);
		ordereds.add(o);
		}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {}
			}
		}
		return ordereds;
	}
	

public Ordered getOrdered(int id) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	Ordered ordered = null;
	try {
		ps = conn.prepareStatement("select * from ordered where orderedId = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Date date = rs.getDate("orderedAt");
			int quantity = rs.getInt("quantity");
			int bookId = rs.getInt("bookId");
			int userId = rs.getInt("userId");
			 ordered = new Ordered(id, date, quantity, bookId, userId);
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
	
	return ordered;
}
public boolean insertOrdered(Ordered ordered) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean inserted = false;
	try {
		
		ps = conn.prepareStatement("insert into ordered (orderedAt, quantity, bookId, userId) values(?,?,?,?)");
		ps.setDate(1,ordered.getOrderedAt());
		ps.setInt(2, ordered.getQuantity());
		ps.setInt(3, ordered.getBookId());
		ps.setInt(4, ordered.getUserId());
		int row = ps.executeUpdate();
		inserted = row > 0;
		
		
		
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
	return inserted;
}

public boolean updateOrdered(Ordered ordered) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean isUpdated = false;
	try {
		ps = conn.prepareStatement("update ordered set orderedAt = ?, quantity = ?, bookId = ?, userId = ? where orderedId = ?");
		ps.setDate(1, ordered.getOrderedAt());
		ps.setInt(2, ordered.getQuantity());
		ps.setInt(3, ordered.getBookId());
		ps.setInt(4, ordered.getUserId());
		ps.setInt(5, ordered.getOrderedId());
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

public boolean deleteOrdered(int id) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean isDeleted = false;
	try {
		ps = conn.prepareStatement("delete from ordered where orderedAt = ?");
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

public boolean checkNumber(String input1, String input2, String input3) {
	try {
		Integer.parseInt(input1);
		Integer.parseInt(input2);
		Integer.parseInt(input3);
		return true;
	} catch(NumberFormatException e) {
		e.printStackTrace();
		return false;
	}
}

public boolean validateDate(String str) {
	int length = str.trim().length();
	if(length != 10) 
		return false;
	else {
		int year = Integer.parseInt(str.substring(0, 4));
		int month = Integer.parseInt(str.substring(5, 7));
		int day  = Integer.parseInt(str.substring(8,10));
		if(year < 2000 || year > 2020)
			return false;
		if(month <= 0 || month > 12)
			return false;
		if(day <= 0 || day > 31) 
			return false;
	}
	return true;
	
	
}


}
