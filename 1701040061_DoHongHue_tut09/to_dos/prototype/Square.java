package to_dos.prototype;

// Create the Square concrete class which extends the Shape abstract class
public class Square extends Shape {
	// TO-DO: Declare the constructor
	public Square() {
		// Set type to be similar with class name
this.type = "Square";
	}

	// TO-DO: Declare the draw() method
	@Override
	public void draw() {
		System.out.println("Draw square");
		/*
		 * Only print out the draw() method to test. No need to implement the real
		 * drawing
		 */

	}
}
