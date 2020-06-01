package ex3;

public class Worker extends Human {
private double salary;
private double workingHour;
protected double getSalary() {
	return this.salary;
}
public Worker() {
	super();
}
public Worker(String firstName, String lastName, double salary,double workingHour) {
	super(firstName, lastName);
	this.salary = salary;
	this.workingHour = workingHour;
}
protected void setSalary(double salary) {
	if(salary < 10) {
		throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
	}
	this.salary = salary;
}

protected void setWorkingHour(double workingHour) {
	if(workingHour < 1 || workingHour > 12) {
		throw new IllegalArgumentException("Expected value mismatch! Argument: workingHoursPerDay");
	}
	this.workingHour = workingHour;
}

protected double getWorkingHour() {
	return this.workingHour;
}
@Override
protected void setLastName(String lastName) {
	super.setLastName(lastName);
}


protected double getSalaryPerHour() {
	return salary / (workingHour * 7);
}
protected String getStringWorkingHour() {
	return String.format("%.0f", this.getWorkingHour());
}
protected String getStringSalary() {
	return String.format("%.0f", this.getSalary());
}
protected String getStringSalaryPerHour() {
	return String.format("%.2f", this.getSalaryPerHour());
}
@Override
public String toString() {
	final StringBuilder sb = new StringBuilder(255);
	sb.append(String.format("First Name: {%s}\n", this.getFirstName()))
		.append(String.format("Last Name: {%s}\n", this.getLastName()))
	.append(String.format("Week Salary: {%s}\n", this.getStringSalary()))
	.append(String.format("Hours per day: {%s}\n", this.getStringWorkingHour()))
	.append(String.format("Salary per hour: {%s}\n", this.getStringSalaryPerHour()));
	return sb.toString();
	
}


}
