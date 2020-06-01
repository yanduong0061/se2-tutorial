package resource;
import service.StudentService;
import model.Student;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/student")
public class StudentResource {
	StudentService studentService = new StudentService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}
	
}
