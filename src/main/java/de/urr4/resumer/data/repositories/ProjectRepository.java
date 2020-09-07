package de.urr4.resumer.data.repositories;

import de.urr4.resumer.data.entities.Project;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProjectRepository {

    private final Logger LOG = LoggerFactory.getLogger(ProjectRepository.class);

    private final SessionFactory sessionFactory;

    @Inject
    public ProjectRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Project> getAllProjects() {
        Session session = sessionFactory.openSession();
        Collection<Project> projects = session.loadAll(Project.class);
        return projects.stream().collect(Collectors.toList());
    }

    public Project getProjectById(Long id) {
        Session session = sessionFactory.openSession();
        Project project = session.load(Project.class, id);
        LOG.info("Found Project " + project);
        return project;
    }

    public Project saveProject(Project project) {
        Session session = sessionFactory.openSession();
        session.save(project);
        return project;
    }

}
