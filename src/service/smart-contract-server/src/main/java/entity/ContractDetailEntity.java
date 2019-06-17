package entity;

import entity.config.EntityPath;
import enums.EnumTest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = EntityPath.CONTRACT_DETAIL)
public class ContractDetailEntity implements Serializable {

    @Id
    @GeneratedValue(generator = EntityPath.CONTRACT_DETAIL_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = EntityPath.CONTRACT_DETAIL_GENERATOR, sequenceName = EntityPath.CONTRACT_DETAIL_SEQUENCE, allocationSize = 1)
    private long id;

    @Column(name = "yyy")
    private long yyy;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "enum_test", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumTest enumTest;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, foreignKey = @ForeignKey(name = "fk_contract_detail_contract_id"))
    @JsonIgnore
    private ContractEntity contract;

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
