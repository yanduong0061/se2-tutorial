package to_dos.factory;

// Creating the Health class that extends Course abstract class 
class Health extends Course {
	private static final int HEALTH_COURSE_DURATION = 70;
	private static final double HEALTH_COURSE_FEE = 500;
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	@Override
	public void getDuration() {
 this.duration = HEALTH_COURSE_DURATION;
 System.out.println("Health course duration: " + this.duration);
	}

	// TO-DO: Implement getFeePerSemester() method: set a specific duration and print value
	@Override
	public void getFeePerSemester() {
 this.fee = HEALTH_COURSE_FEE;
 System.out.println("Health course fee: " + this.fee);
	}
}// end of Health class.