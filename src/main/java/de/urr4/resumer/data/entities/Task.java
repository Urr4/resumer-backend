package de.urr4.resumer.data.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    private String description;
}
