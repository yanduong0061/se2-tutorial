package service;
import java.util.List;
import java.util.ArrayList;
import model.Teacher;
public class TeacherService {
public List<Teacher> getAllTeachers() {
	List<Teacher> teachers = new ArrayList<Teacher>();
	Teacher teacher1 = new Teacher(1, "Truong Hoai Duong", "Bachelors in Information Technology and Information Systems");
	Teacher teacher2 = new Teacher(2, "Do Van Nam", "Bachelors in Computer Science");
	Teacher teacher3 = new Teacher(3, "Dieu Linh", "Bachelors in information technology");
	teachers.add(teacher1);
	teachers.add(teacher2);
	teachers.add(teacher3);
	return teachers;
}
}
