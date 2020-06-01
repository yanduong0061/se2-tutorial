package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
public class Student {
private int studentId;


private String name;
private String mobilePhone;

public Student(int studentId, String name, String mobilePhone) {
	super();
	this.studentId = studentId;
	this.name = name;
	this.mobilePhone = mobilePhone;
}


public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMobilePhone() {
	return mobilePhone;
}

public void setMobilePhone(String mobilePhone) {
	this.mobilePhone = mobilePhone;
}
}

