package to_dos.prototype;

/* Create the ShapeDraw class which uses ShapeCache class 
to get clones of shapes stored in a Hashtable. */
public class ShapeDraw {
	// TO-DO: Implement the main() method for testing purpose
	public static void main(String[] args) {
		// run loadCache() method
	ShapeCache.loadCache();
	
		/*
		 * create 3 cloned shapes with 3 different types Hint: use getShape() &
		 * getType() methods
		 */
	Shape shape1 = ShapeCache.getShape("1");
	Shape shape2 = ShapeCache.getShape("2");
	Shape shape3 = ShapeCache.getShape("3");
	System.out.println(shape1.getType());
	System.out.println(shape2.getType());
	System.out.println(shape3.getType());


	}
}
