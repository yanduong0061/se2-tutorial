package model;

public class Subject {
private int subjectId;
private String name;
private String timeOfTraining;
public Subject(int subjectId, String name, String timeOfTraining) {
	super();
	this.subjectId = subjectId;
	this.name = name;
	this.timeOfTraining = timeOfTraining;
}
public int getSubjectId() {
	return subjectId;
}
public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTimeOfTraining() {
	return timeOfTraining;
}
public void setTimeOfTraining(String timeOfTraining) {
	this.timeOfTraining = timeOfTraining;
}

}
