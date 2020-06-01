package to_dos.prototype;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import to_dos.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/* Create the ShapeCache class to get concrete classes from database 
   and store them in a Hashtable. */
public class ShapeCache {
private static final String SQL_SELECT = "select * from shape_table";
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	/*
	 * TO-DO: Implement the loadCache() method 
	 * For each shape run database query and
	 * create shape shapeMap.put(shapeKey, shape);
	 */
	public static void loadCache() {
		try {
			DBHelper db = DBHelper.getDBHelper();
			db.openConnection();
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("shape_id");
				String type = rs.getString("shape_type");
				if(type.equalsIgnoreCase("Circle")) {
					Shape c = new Circle();
					c.setId(id);
					c.setType(type);
					shapeMap.put(id, c);
				} else if(type.equalsIgnoreCase("Rectangle")) {
					Shape r = new Rectangle();
					r.setId(id);
					r.setType(type);
					shapeMap.put(id, r);
				} else if(type.equalsIgnoreCase("Square")) {
					Shape s = new Square();
					s.setId(id);
					s.setType(type);
					shapeMap.put(id, s);
				} else {
					break;
				}
					
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
 	}
}