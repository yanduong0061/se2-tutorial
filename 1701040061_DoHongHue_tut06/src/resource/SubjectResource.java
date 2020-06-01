package resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Subject;
import service.SubjectService;

@Path("/subject")
public class SubjectResource {
	SubjectService subjectService = new SubjectService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Subject> getAllSubject() {
		return subjectService.getAllSubjects();
	}

}
