package de.urr4.resumer.data.repositories;

import de.urr4.resumer.data.entities.Skill;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SkillRepository {

    private final SessionFactory sessionFactory;

    @Inject
    public SkillRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Skill> getAllSkills() {
        Session session = sessionFactory.openSession();
        Collection<Skill> skills = session.loadAll(Skill.class);
        return skills.stream().collect(Collectors.toList());
    }
}
