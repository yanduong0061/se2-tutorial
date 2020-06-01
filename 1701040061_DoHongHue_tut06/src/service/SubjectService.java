package service;
import model.Subject;
import java.util.List;
import java.util.ArrayList;
public class SubjectService {
public List<Subject> getAllSubjects() {
	List<Subject> subjects = new ArrayList<>();
	Subject subject1 = new Subject(1, "DBS", "6 months");
	Subject subject2 = new Subject(2, "SS1", "3 months");
	Subject subject3 = new Subject(3, "SS2", "3 months");
	subjects.add(subject1);
	subjects.add(subject2);
	subjects.add(subject3);
	return subjects;
	
	
	
}
}
