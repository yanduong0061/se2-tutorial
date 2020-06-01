package resource;
import model.Teacher;
import service.TeacherService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/teacher")
public class TeacherResource {
	TeacherService teacherService = new TeacherService();
@GET
@Produces(MediaType.APPLICATION_XML)
public List<Teacher> getTeachers() {
	return teacherService.getAllTeachers();
}
}
