package to_dos.factory;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Create the CourseInformation class to generate information about the duration 
 * and fee of the course by using the Admission class to get the object of 
 * sub-classes by passing the required information like the course being applied for */
class CourseInformation {
	public static void main(String args[]) throws IOException {
		//TO-DO: Create new Admission object
	Admission ad = new Admission();

		//TO-DO: Get user's input for the course's name
	System.out.println("Enter the course's name");
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//TO-DO: Create new course with created Admission
		Course c = ad.admittingCourse(br.readLine());
		if(c == null) {
			System.err.println("Course is not existed!");
		} else {
			c.getDuration();
			c.getFeePerSemester();
			c.calculateTotalFee();
		}
		//TO-DO: Display the require duration in semesters, required fee per semester and whole entire course

	}
}  