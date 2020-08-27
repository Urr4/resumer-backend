package de.urr4.resumer.resources;

import de.urr4.resumer.data.entities.Address;
import de.urr4.resumer.data.entities.User;
import de.urr4.resumer.data.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@ApplicationScoped
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final Logger LOG = LoggerFactory.getLogger(UserResource.class);
    @Inject
    private UserRepository userRepository;

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

        return userRepository.saveOwner(user);
    }
}
