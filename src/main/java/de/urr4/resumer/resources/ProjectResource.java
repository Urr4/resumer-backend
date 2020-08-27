package de.urr4.resumer.resources;

import de.urr4.resumer.data.entities.Project;
import de.urr4.resumer.data.entities.Role;
import de.urr4.resumer.data.entities.Skill;
import de.urr4.resumer.data.entities.Task;
import de.urr4.resumer.data.repositories.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
@Path("/projects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {

    private final Logger LOG = LoggerFactory.getLogger(ProjectResource.class);
    @Inject
    private ProjectRepository projectRepository;

    @GET
    public List<Project> getAllProjects() {
        LOG.info("Getting all projects");
        List<Project> projects = projectRepository.getAllProjects();
        LOG.debug("Found " + projects.size() + " projects");
        return projects;
    }

    @GET
    @Path("/{id}")
    public Project getProject(@PathParam("id") Long id) {
        LOG.info("Getting project for id " + id);
        Project project = projectRepository.getProjectById(id);
        LOG.debug("Found project " + project);
        return project;
    }

    @POST
    public void saveProject() {
        Project p1 = new Project();
        p1.setTitle("Some Title");
        p1.setDescription("Worked as someone");

        Role dev = new Role();
        dev.setName("Developer");
        Role arc = new Role();
        arc.setName("Architect");
        p1.setRoles(Arrays.asList(dev, arc));

        Skill s1 = new Skill();
        s1.setName("Java");
        s1.setLevel(5);
        Skill s2 = new Skill();
        s2.setName("Other");
        s2.setLevel(3);
        p1.setRequiredSkills(Arrays.asList(s1, s2));

        Task t1 = new Task();
        t1.setDescription("Collected Requirements");
        p1.setTasks(Arrays.asList(t1));

        projectRepository.saveProject(p1);
    }
}
