package to_dos.factory;

// Create the CivilService class that extends Course abstract class 
class CivilService extends Course {
	private static final int CIVIL_SERVICE_COURSE_DURATION = 50;
	private static final double CIVIL_SERVICE_COURSE_FEE = 350;
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	@Override
	public void getDuration() {
 this.duration = CIVIL_SERVICE_COURSE_DURATION;
 System.out.println("Civil service course's duration: " + this.duration);
	}
@Override
	// TO-DO: Implement getFeePerSemester() method: set a specific duration and print value
	public void getFeePerSemester() {
 this.fee = CIVIL_SERVICE_COURSE_FEE;
 System.out.println("Civil service course's fee: " + this.fee);
	}
}