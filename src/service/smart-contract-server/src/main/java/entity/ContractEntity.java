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
@Table(name = EntityPath.CONTRACT)
public class ContractEntity implements Serializable {

    @Id
    @GeneratedValue(generator = EntityPath.CONTRACT_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = EntityPath.CONTRACT_GENERATOR, sequenceName = EntityPath.CONTRACT_SEQUENCE, allocationSize = 1)
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "enum_test", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumTest enumTest;

    @OneToMany(mappedBy = "contract", fetch = FetchType.EAGER)
    private List<ContractDetailEntity> detail;

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
