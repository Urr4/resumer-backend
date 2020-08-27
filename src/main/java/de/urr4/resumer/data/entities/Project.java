package de.urr4.resumer.data.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@Data
@NodeEntity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    private List<Role> roles;

    private List<Skill> requiredSkills;

    private List<Task> tasks;
}
