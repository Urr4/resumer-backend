package de.urr4.resumer.resources;

import de.urr4.resumer.data.entities.*;
import de.urr4.resumer.data.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Arrays;

@ApplicationScoped
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final Logger LOG = LoggerFactory.getLogger(UserResource.class);

    private final UserRepository userRepository;

    @Inject
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") Long id) {
        LOG.info("Getting user for id " + id);
        User user = userRepository.getUserById(id);
        LOG.debug("Found user " + user);
        return user;
    }

    @POST
    public User saveOwner() {
        User user = new User();
        user.setFirstname("Stefan");
        user.setLastname("Schubert");
        user.setCitizenship("German");
        user.setPhonenumber("(+49) 170 3601598");
        user.setBirthday(LocalDate.of(1986, 2, 8));

        Address address = new Address();
        address.setCity("Mönchengladbach");
        address.setStreet("Mathildenstraße");
        address.setNumber("102");
        address.setPostalCode(41239);
        user.setAddress(address);

        Task t1 = new Task();
        t1.setDescription("Some task");
        Task t2 = new Task();
        t2.setDescription("Some other task");

        //PRof BG
        ProfessionalBackground b1 = new ProfessionalBackground();
        b1.setFrom(LocalDate.of(2019, 1, 1));
        b1.setTo(LocalDate.of(2020, 1, 1));
        b1.setPosition("Head of Everything");
        Employer e = new Employer();
        e.setCity("Düsseldorf");
        e.setName("Prodyna SE");
        b1.setEmployer(e);
        b1.setTasks(Arrays.asList(t2, t2));
        user.setProfessionalBackgrounds(Arrays.asList(b1));

        //TODO
        Education e1 = new Education();
        e1.setFrom(LocalDate.of(2018, 1, 1));
        e1.setTo(LocalDate.of(2018, 1, 2));
        e1.setTitle("Skipped school");
        e1.setSubtitle("Forever");
        e1.setGraduation("None");
        e1.setDegree(666.5);
        user.setEducations(Arrays.asList(e1));

        //Skills
        Skill s1 = new Skill();
        s1.setName("Java");
        SkillRelation sr1 = new SkillRelation();
        sr1.setUser(user);
        sr1.setSkill(s1);
        sr1.setLevel(5);
        Skill s2 = new Skill();
        s2.setName("Magic");
        SkillRelation sr2 = new SkillRelation();
        sr2.setUser(user);
        sr2.setSkill(s2);
        sr2.setLevel(3);
        user.setSkillRelations(Arrays.asList(sr1, sr2));

        //Projects
        Project p1 = new Project();
        p1.setTasks(Arrays.asList(t1));
        p1.setDescription("Some description");
        p1.setTitle("Some title");
        Role r1 = new Role();
        r1.setName("Master");
        Role r2 = new Role();
        r2.setName("Minister");
        p1.setRoles(Arrays.asList(r1, r2));
        p1.setRequiredSkills(Arrays.asList(s1, s2));
        user.setProjects(Arrays.asList(p1));

        // Qualis
        Qualification q1 = new Qualification();
        q1.setName("Received a letter saying 'thank you for nothing'");
        Qualification q2 = new Qualification();
        q2.setName("Did Magic");
        user.setQualifications(Arrays.asList(q1, q2));

        //Languages
        Language l1 = new Language();
        l1.setName("Elvish");
        LanguageRelation lr1 = new LanguageRelation();
        lr1.setUser(user);
        lr1.setLanguage(l1);
        lr1.setLanguageLevel(LanguageLevel.BEGINNER);
        user.setLanguageRelations(Arrays.asList(lr1));

        //Misc
        Misc m1 = new Misc();
        m1.setTitle("Eaten a book");


        return userRepository.saveOwner(user);
    }
}
