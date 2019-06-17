package entity;

import entity.config.EntityPath;
import enums.EnumTest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = EntityPath.USER)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(generator = EntityPath.USER_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = EntityPath.USER_GENERATOR, sequenceName = EntityPath.USER_SEQUENCE, allocationSize = 1)
    private long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;


    @JsonIgnore
    @Version
    @Column(name = "version_update")
    private Long version;

    @JsonIgnore
    @Transient
    public boolean isNew() {
        return id == 0;
    }

}
