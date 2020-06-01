package service;
import model.Student;
import java.util.List;
import java.util.ArrayList;
public class StudentService {
	
	public List<Student> getAllStudents() {
		Student s1 = new Student(1, "Duong Linh", "1234455");
		Student s2 = new Student(2, "Ha Quan", "12324241");
		Student s3 = new Student(3, "Van Lan", "24342423");
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		return list;
	}
}
