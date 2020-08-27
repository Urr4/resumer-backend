package de.urr4.resumer.data.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;


@Data
@NodeEntity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;

    private String phonenumber;

    @Relationship(type = "ADDRESS")
    private Address address;

    private LocalDate birthday;

    private String citizenship;

}
