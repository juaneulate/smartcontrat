package entity;

import entity.config.EntityPath;
import enums.EnumTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = EntityPath.LOGIN)
public class LoginEntity implements Serializable {


    public LoginEntity(String login, String password, PersonEntity personEntity) {
        this.login = login;
        this.password = password;
        this.personEntity = personEntity;
    }

    @Id
    @GeneratedValue(generator = EntityPath.LOGIN_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = EntityPath.LOGIN_GENERATOR, sequenceName = EntityPath.LOGIN_SEQUENCE, allocationSize = 1)
    private long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name="idpersona")
    private PersonEntity personEntity;


    @JsonIgnore
    @Transient
    public boolean isNew() {
        return id == 0;
    }

}
