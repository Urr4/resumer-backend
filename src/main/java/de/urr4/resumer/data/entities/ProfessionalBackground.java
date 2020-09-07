package de.urr4.resumer.data.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;
import java.util.List;

@Data
@NodeEntity
public class ProfessionalBackground {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate from;
    private LocalDate to;

    private String position;
    private Employer employer;

    @Relationship(type = "INVOLVED_TASKS")
    private List<Task> tasks;
}
