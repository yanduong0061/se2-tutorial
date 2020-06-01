package tuts.tut10.to_dos.adapter.round;

/**
 * RoundHoles are compatible with RoundPegs.
 */
public class RoundHole {
	private double radius;
	//TO-DO: Declare an attribute: name = radius, type = double

	//TO-DO: Declare the constructor with a parameter
public RoundHole(double radius) {
	this.radius = radius;
}
	//TO-DO: Implement getRadius() method
	public double getRadius() {
		return this.radius;
	}

	//TO-DO: Implement fits() method
	public boolean fits(RoundPeg peg) {
		boolean result = false;
		//if getRadius() of RoundHole >= getRadius() of RoundPeg => return true
		//else return false
		result = this.radius >= peg.getRadius();
		 
		return result;
	}
}
