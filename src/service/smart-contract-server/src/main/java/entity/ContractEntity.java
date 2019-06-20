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
    private String registro_billetera;

    @Column(name = "monto_total")
    private BigDecimal monto_total;

    @Column(name = "cuota")
    private BigDecimal cuota;

    @Column(name = "estado_contrato")
    private Boolean estado_contrato;

    @Column(name = "nombre_contrato")
    private String nombre_contrato;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idpersona")
    @JsonIgnore
    private PersonEntity personEntity;

    @JsonIgnore
    @Transient
    public boolean isNew() {
        return idcontrato == 0;
    }

    @JsonIgnore
    @Transient
    public static ContractEntity build(String registro_billetera,BigDecimal monto_total, BigDecimal cuota, boolean estado_contrato,String nombre_contrato,PersonEntity personEntity) {
        return ContractEntity.builder().registro_billetera(registro_billetera).monto_total(monto_total).cuota(cuota).estado_contrato(estado_contrato).nombre_contrato(nombre_contrato).personEntity.(personEntity).build();
    }


}
