package to_dos.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DBHelper {
	
private static final String DB_URL = "jdbc:mysql://localhost:3306/shape_db?autoconnect=true&&userSSL=false";
private static final String USERNAME = "root";
private static final String PASSWORD = "12345678";
private Connection conn = null;
private DBHelper() {
	
}
private static class InnerDBHelper {
	private static final DBHelper dbhelper = new DBHelper();
	
}
public static DBHelper getDBHelper() {
	return InnerDBHelper.dbhelper;
}

public boolean openConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		System.out.println("Connect successfully!");
		return true;
	} catch(Exception e) {
		e.printStackTrace();
		System.err.println("Connect failed!");
		return false;
	}
}

public Connection getConnection() {
	return this.conn;
}

public void closeConnection() {
try {
		if(this.conn != null) {
			this.conn.close();
		}
		
			
	} catch(Exception e) {
		e.printStackTrace();
	}
}

public void closePs(PreparedStatement ps) {
	try {
		if(ps != null) {
			ps.close();
		}
		
			
	} catch(Exception e) {
		e.printStackTrace();
	}
}
}
