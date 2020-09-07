package de.urr4.resumer.data.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import javax.json.bind.annotation.JsonbTransient;
import java.util.Objects;

@Data
@RelationshipEntity(type = "HAS_SKILL")
public class SkillRelation {

    @Id
    @GeneratedValue
    private Long id;

    @JsonbTransient
    @StartNode
    private User user;

    @EndNode
    private Skill skill;

    private int level;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillRelation that = (SkillRelation) o;
        return level == that.level &&
                Objects.equals(id, that.id) &&
                Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, level);
    }
}
