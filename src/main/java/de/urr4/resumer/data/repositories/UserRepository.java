package de.urr4.resumer.data.repositories;

import de.urr4.resumer.data.entities.User;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserRepository {

    @Inject
    private SessionFactory sessionFactory;

    private final Logger LOG = LoggerFactory.getLogger(UserRepository.class);

    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.load(User.class, id);
        LOG.info("Found user "+user);
        return user;
    }

    public User saveOwner(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        return user;
    }

}
