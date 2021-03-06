package entity;

import entity.config.EntityPath;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"personId"})
@Entity
@Table(name = EntityPath.PERSON)
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(generator = EntityPath.PERSON_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = EntityPath.PERSON_GENERATOR, sequenceName = EntityPath.PERSON_SEQUENCE, allocationSize = 1)
    @Column(name = "idpersona", nullable = false)
    private long personId;

    @Column(name = "nombrecompleto", nullable = false)
    private String fullName;

    @Column(name = "edad", nullable = false)
    private int age;

    @Column(name = "tipopersona", nullable = false)
    private boolean personType;

    @JsonIgnore
    @Transient
    public static PersonEntity build(String fullName, int age, boolean personType) {
        return PersonEntity.builder().fullName(fullName).age(age).personType(personType).build();
    }

    @JsonIgnore
    @Transient
    public boolean isNew() {
        return personId == 0;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
