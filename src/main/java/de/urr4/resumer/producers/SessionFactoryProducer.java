package de.urr4.resumer.producers;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class SessionFactoryProducer {

    private static final String ENTITY_PACKAGE = "de.urr4.resumer.data.entities";

    @ConfigProperty(name = "neo4j.url")
    String neo4jUrl;

    @ConfigProperty(name = "neo4j.user")
    String neo4jUser;

    @ConfigProperty(name = "neo4j.password")
    String neo4jPassword;

    @Produces
    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration.Builder()
                .uri(neo4jUrl)
                .credentials(neo4jUser, neo4jPassword)
                .build();
        return new SessionFactory(configuration, ENTITY_PACKAGE);
    }

    public void dispose(@Disposes SessionFactory sessionFactory) {
        sessionFactory.close();
    }
}
