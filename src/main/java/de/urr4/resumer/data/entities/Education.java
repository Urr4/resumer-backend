package de.urr4.resumer.data.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.time.LocalDate;

@Data
@NodeEntity
public class Education {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate from;
    private LocalDate to;

    private String title;
    private String subtitle;
    private String graduation;
    private Double degree;
}
