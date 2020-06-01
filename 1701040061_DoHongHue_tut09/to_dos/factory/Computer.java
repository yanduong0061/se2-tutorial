package to_dos.factory;

// Create the Computer class that extends Courses abstract class 
class Computer extends Course {
	private static final int COMPUTER_COURSE_DURATION = 48;
	private static final double COMPUTER_COURSE_FEE = 400;
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	@Override
	public void getDuration() {
 this.duration = COMPUTER_COURSE_DURATION;
 System.out.println("Computer course duration: " + this.duration);
	}

	// TO-DO: Implement getFeePerSemester() method: set a specific duration and print value
	@Override
	public void getFeePerSemester() {
 this.fee = COMPUTER_COURSE_FEE;
	 System.out.println("Computer course fee: " + this.fee);
	}
} 
