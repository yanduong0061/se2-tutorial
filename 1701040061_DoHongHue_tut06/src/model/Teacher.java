package model;

public class Teacher {
private int teachId;


private String name;
private String degree;
public Teacher(int teachId, String name, String degree) {
	super();
	this.teachId = teachId;
	this.name = name;
	this.degree = degree;
}
public int getTeachId() {
	return teachId;
}
public void setTeachId(int teachId) {
	this.teachId = teachId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}

}
