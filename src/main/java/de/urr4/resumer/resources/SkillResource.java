package de.urr4.resumer.resources;

import de.urr4.resumer.data.entities.Skill;
import de.urr4.resumer.data.repositories.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/skills")
@Produces(MediaType.APPLICATION_JSON)
public class SkillResource {

    private final Logger LOG = LoggerFactory.getLogger(SkillResource.class);

    private final SkillRepository skillRepository;

    @Inject
    public SkillResource(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GET
    public List<Skill> getAllSkills() {
        LOG.info("Getting all skills");
        List<Skill> skills = skillRepository.getAllSkills();
        LOG.debug("Found " + skills.size() + " skills");
        return skills;
    }


}
