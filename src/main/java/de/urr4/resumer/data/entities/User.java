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
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String phonenumber;
    private LocalDate birthday;
    private String citizenship;

    @Relationship(type = "ADDRESS")
    private Address address;

    @Relationship(type = "HAS_BACKGROUNDS")
    private List<ProfessionalBackground> professionalBackgrounds;

    @Relationship(type = "HAS_EDUCATION")
    private List<Education> educations;

    @Relationship(type = "WORKED_IN")
    private List<Project> projects;

    @Relationship(type = "HAS_QUALIFICATIONS")
    private List<Qualification> qualifications;

    @Relationship(type = "SPEAKS")
    private List<LanguageRelation> languageRelations;

    @Relationship(type = "HAS_SKILL")
    private List<SkillRelation> skillRelations;

    @Relationship(type = "MISC")
    private List<Misc> miscs;
}
