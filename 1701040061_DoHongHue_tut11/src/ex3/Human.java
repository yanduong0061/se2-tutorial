package ex3;

public class Human {
	private String firstName;
public Human(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
}
public Human() {
	
}

protected String getFirstName() {
	return firstName;
}
protected void setFirstName(String firstName) {
	
	if(!Character.isUpperCase(firstName.toCharArray()[0])){
		throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");
	} else if(firstName.length() <4) {
			throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
		}
	 else {
		this.firstName = firstName;
	}

}
protected String getLastName() {
	return lastName;
}
protected void setLastName(String lastName) {
	if(!Character.isUpperCase(lastName.toCharArray()[0])) {
		throw new IllegalArgumentException("Expected upper case letter! Argument: lastName");
	} else if(lastName.length() < 3) {
		throw new IllegalArgumentException("Expected length at least 3 symbols! Argument: lastName");
	} else {
		this.lastName = lastName;
	}
}

@Override
public String toString() {
	final StringBuilder sb = new StringBuilder();
	sb.append(String.format("First Name : {%s}\n", this.getFirstName()))
	.append(String.format("Last Name: {%s}\n", this.getLastName()));
	return sb.toString();
}
private String lastName;
}
