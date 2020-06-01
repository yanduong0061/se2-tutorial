package ex3;

public class Student extends Human {
	private String fNumber;
	public Student() {
		super();
	}
public Student(String fN, String lN, String fNumber) {
	super(fN, lN);
	this.fNumber = fNumber;
}

public void setFalcutyNumber(String fNumber) {
	if(fNumber.isEmpty()) {
		throw new IllegalArgumentException("Invalid falcuty number! Number can not be empty!");
	}
	boolean isNumber = Integer.parseInt(fNumber) > 0;
	if(!isNumber) {
		throw new IllegalArgumentException("Invalid number!");
	}
	if(fNumber.length() < 5 | fNumber.length() > 10) {
		throw new IllegalArgumentException("Invalid faculty number!");
	} else {
		this.fNumber = fNumber;
	}
}
public String getFalcutyNumber() {
	return this.fNumber;
}
@Override
public String toString() {
	final StringBuilder sb = new StringBuilder();
	return super.toString() + sb.append(String.format("Falcuty Number: {%s}", this.getFalcutyNumber())).toString();
}

}
