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

    @Column(name = "hash_contract")
    private String hashContract;

    @Column(name = "json_contract")
    private String jsonContract;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "idpersona")
    private PersonEntity personEntity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "idtenant")
    private PersonEntity tenantEntity;

    @JsonIgnore
    @Transient
    public boolean isNew() {
        return idcontrato == 0;
    }

    @JsonIgnore
    @Transient
    public static ContractEntity build(String registroBilletera, BigDecimal montoTotal, BigDecimal cuota,
                                       boolean estadoContrato, String nombreContrato, String jsonContract, String hashContract, PersonEntity personEntity) {
        return ContractEntity.builder().
                registroBilletera(registroBilletera).
                montoTotal(montoTotal).
                cuota(cuota).
                estadoContrato(estadoContrato).
                nombreContrato(nombreContrato).
                jsonContract(jsonContract).
                hashContract(hashContract).
                personEntity(personEntity).
                build();
    }
}
