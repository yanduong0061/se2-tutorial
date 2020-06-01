package dao;
import model.User;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class UserImp implements UserDAO {
public UserImp() {
	
}

@Override
public User getUser(int userId) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	User u = null;
	try {
		ps = conn.prepareStatement("select * from user where userId = ?");
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			String address =rs.getString("address");
			String phoneNumber = rs.getString("phoneNumber");
			u = new User(userId, name, address, phoneNumber);
		}
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
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
	return u;
}
@Override
public List<User> getAllUser() {
	List<User> users = new ArrayList<>();
	Connection conn = DatabaseConnection.getConnection();
	String sql_all = "select * from user";
	PreparedStatement ps = null;
	try {
	ps = conn.prepareStatement(sql_all);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		int userId = rs.getInt("userId");
		String name = rs.getString("name");
		String address = rs.getString("address");
		String phoneNumber = rs.getString("phoneNumber");
		User u = new User(userId, name, address, phoneNumber);
		users.add(u);
	}
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
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
	return users;
}

@Override
public boolean insertUser(User user) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean inserted = false;
	try {
	 ps = conn.prepareStatement("insert into user " + "(name, address, phoneNumber) " + "values(?, ?, ?);");
	 ps.setString(1,  user.getName());
	 ps.setString(2, user.getAddress());
	 ps.setString(3, user.getPhoneNumber());
	 int row = ps.executeUpdate();
	 inserted = row > 0;
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
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
	return inserted;
}

@Override
public boolean updateUser(User u) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean isUpdated = false;
	try {
		ps = conn.prepareStatement("update user set name = ?, address = ?, phoneNumber = ? where userId = ?;");
		ps.setString(1, u.getName());
		ps.setString(2, u.getAddress());
		ps.setString(3, u.getAddress());
		ps.setInt(4, u.getId());
		int row = ps.executeUpdate();
		isUpdated = row > 0;
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
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
	return isUpdated;
}

@Override
public boolean deleteUser(int id) {
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = null;
	boolean isDeleted = false;
	try {
		ps = conn.prepareStatement("delete from user where userId = ?");
		ps.setInt(1, id);
	int row = ps.executeUpdate();
	isDeleted = row > 0;
	
	} catch(SQLException e) {
		DatabaseConnection.printSQLException(e);
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
	return isDeleted;
}


}
