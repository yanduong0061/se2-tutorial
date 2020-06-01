package ex1;

public class Person {
private String name;
private int age;
public Person(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
protected String getName() {
	return name;
}
protected void setName(String name)throws IllegalArgumentException  {
	if(name.length() < 3) {
		throw new IllegalArgumentException("Name length need to be larger than 3!");
	}
	else {
		this.name = name;
	}

}
protected int getAge() {
	return age;
}
protected void setAge(int age) throws IllegalArgumentException {
	if(age < 1) {
		throw new IllegalArgumentException("Age can not be negative!");
	} else {
		this.age = age;
	}
	
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(String.format("Name: %s, Age: %d", this.getName(), this.getAge() ));
	return builder.toString();
}
}
