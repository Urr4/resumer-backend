package de.urr4.resumer.data.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import javax.json.bind.annotation.JsonbTransient;
import java.util.Objects;

@Data
@RelationshipEntity(type = "SPEAKS")
public class LanguageRelation {

    @Id
    @GeneratedValue
    private Long id;

    @JsonbTransient
    @StartNode
    private User user;

    @EndNode
    private Language language;

    private LanguageLevel languageLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageRelation that = (LanguageRelation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(language, that.language) &&
                languageLevel == that.languageLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, languageLevel);
    }
}
