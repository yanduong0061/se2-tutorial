package to_dos.prototype;

//Create the Rectangle concrete class which extends the Shape abstract class
public class Rectangle extends Shape {
	// TO-DO: Declare the constructor
	public Rectangle() {
		// Set type to be similar with class name
this.type = "Rectangle";
	}

	// TO-DO: Declare the draw() method
	@Override
	public void draw() {
		System.out.println("Draw Rectanble");
		/*
		 * Only print out the draw() method to test. No need to implement the real
		 * drawing
		 */

	}
}