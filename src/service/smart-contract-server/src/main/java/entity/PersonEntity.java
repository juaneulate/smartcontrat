package entity;

import entity.config.EntityPath;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Data
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
    private String lastName;

    @Column(name = "edad", nullable = false)
    private int age;



    @Column(name = "tipopersona", nullable = false)
    private boolean personType;



    @JsonIgnore
    @Transient
    public boolean isNew() {
        return personId == 0;
    }

    public void setPersonType(boolean personType) {
        this.personType = personType;
    }

}
