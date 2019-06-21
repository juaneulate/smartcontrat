package entity;

import entity.config.EntityPath;
import enums.EnumTest;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"idcontrato"})
@Entity
@Table(name = EntityPath.CONTRACT)
public class ContractEntity implements Serializable {

    @Id
    @GeneratedValue(generator = EntityPath.CONTRACT_GENERATOR, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = EntityPath.CONTRACT_GENERATOR, sequenceName = EntityPath.CONTRACT_SEQUENCE, allocationSize = 1)
    private long idcontrato;

    @Column(name = "reg_billetera")
    private String registroBilletera;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "cuota")
    private BigDecimal cuota;

    @Column(name = "estado_contrato")
    private Boolean estadoContrato;

    @Column(name = "nombre_contrato")
    private String nombreContrato;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "idpersona")
    private PersonEntity personEntity;

    @JsonIgnore
    @Transient
    public boolean isNew() {
        return idcontrato == 0;
    }

    @JsonIgnore
    @Transient
    public static ContractEntity build(String registroBilletera,BigDecimal montoTotal,
                                       BigDecimal cuota, boolean estadoContrato,String nombreContrato,PersonEntity personEntity) {
        return ContractEntity.builder().registroBilletera(registroBilletera).montoTotal(montoTotal).cuota(cuota).estadoContrato(estadoContrato).nombreContrato(nombreContrato).personEntity(personEntity).build();
    }
}
