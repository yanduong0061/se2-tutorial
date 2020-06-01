package to_dos.factory;

// Create the abstract class called Course
abstract class Course {
	protected int duration;
	protected double fee;
public abstract void getDuration();
public abstract void getFeePerSemester();
public void calculateTotalFee() {
	double total = duration * fee;
	System.out.println("Total fee of course: " + total);
}
	// TO-DO: Declare 2 void abstract methods: getDuration(), getFeePerSemester()

	// TO-DO: Declare void method: calculateTotalFee(). Total = duration * fee

}