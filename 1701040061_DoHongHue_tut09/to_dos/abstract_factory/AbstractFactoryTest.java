package to_dos.abstract_factory;

/* Create the AbstractFactoryTest class which uses the FactoryProducer 
 * to get AbstractFactory in order to get factories 
 * of concrete classes by passing an information such as type.
 */

public class AbstractFactoryTest {
	//TO-DO: Implement the main() method for testing purpose
	public static void main(String[] args) {
		// get shape factory
 AbstractFactory shapeFactory = new ShapeFactory();
		// get an object of Shape Rectangle
 Shape rectangle = shapeFactory.getShape("Rectangle");
		// call draw method of Shape Rectangle
 rectangle.draw();
		// get an object of Shape Square
 Shape square = shapeFactory.getShape("Square");
		// call draw method of Shape Square
 square.draw();
		// get shape factory
 AbstractFactory roundedShapeFactory = new RoundedShapeFactory();
		// get an object of Shape Rectangle
 Shape roundedRectangle = roundedShapeFactory.getShape("Rectangle");
		// call draw method of Shape Rectangle
 roundedRectangle.draw();
		// get an object of Shape Square
 Shape roundedSquare = roundedShapeFactory.getShape("Square");
		// call draw method of Shape Square
roundedSquare.draw();
	}
}