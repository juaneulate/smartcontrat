package entity;

import entity.config.EntityPath;
import enums.EnumTest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(of = {"idcontrato"})
@Entity
@Table(name = EntityPath.CONTRACT)
public class ContractEntity implements Serializable {

    @Id
    @GeneratedValue(generator = EntityPath.CONTRACT_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = EntityPath.CONTRACT_GENERATOR, sequenceName = EntityPath.CONTRACT_SEQUENCE, allocationSize = 1)
    private long idcontrato;

    @Column(name = "reg_billetera")
    private String reg_billetera;

    @Column(name = "monto_total")
    private BigDecimal monto_total;

    @Column(name = "cuota")
    private BigDecimal cuota;

    @Column(name = "estado_contrato")
    private Boolean estado_contrato;

    @Column(name = "nombre_contrato")
    private String nombre_contrato;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "idpersona")
    private PersonEntity personEntity;

    @JsonIgnore
    @Transient
    public boolean isNew() {
        return idcontrato == 0;
    }

}
