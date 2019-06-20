package dto;

import entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

    private String registroBilletera;
    private BigDecimal montoTotal;
    private BigDecimal cuota;
    private boolean estadoContrato;
    private String nombreContrato;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegistroBilletera() {
        return registroBilletera;
    }

    public void setRegistroBilletera(String registroBilletera) {
        this.registroBilletera = registroBilletera;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public boolean isEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(boolean estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public String getNombreContrato() {
        return nombreContrato;
    }

    public void setNombreContrato(String nombreContrato) {
        this.nombreContrato = nombreContrato;
    }
}
