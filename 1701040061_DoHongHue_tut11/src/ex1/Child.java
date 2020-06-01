
package ex1;

public class Child extends Person{
	private int height;
public Child(String name, int age, int height) {
	super(name, age);
	this.height = height;
}

@Override
protected void setAge(int age) throws IllegalArgumentException {
	if(age > 15) {
		throw new IllegalArgumentException("Child's age need to be smaller than 15!");
	} else {
		super.setAge(age);
	}
}


protected void setHeight(int height) throws IllegalArgumentException {
	if(height < 0) {
		throw new IllegalArgumentException("Height can not be negative!");
	} else {
		this.height = height;
	}
}

protected int getHeight() {
	return height;
}
@Override
public String toString() {
	final StringBuilder builder = new StringBuilder();
	builder.append(String.format("Name: %s, Age: %d", this.getName(),  this.getAge()));
	return builder.toString();
}
}
