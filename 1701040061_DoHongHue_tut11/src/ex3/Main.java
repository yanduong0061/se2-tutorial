package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
public static void main(String[] args) throws IOException {
	try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first name: ");
		String firstName = reader.readLine();
		System.out.println("Enter last name: ");
		String lastName = reader.readLine();
		System.out.println("Enter the falcuty number: ");
		String fb = reader.readLine();
		System.out.println("Enter the week salary: ");
		double weekSalary = Double.parseDouble(reader.readLine());
		System.out.println("Enter the working hour per day: ");
		double workingHour = Double.parseDouble(reader.readLine());
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setFalcutyNumber(fb);
		Worker worker = new Worker();
		worker.setFirstName(firstName);
		worker.setLastName(lastName);
		worker.setSalary(weekSalary);
		worker.setWorkingHour(workingHour);
		System.out.println(student.toString());
		System.out.println(worker.toString());
		
	} catch(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}
}
}
