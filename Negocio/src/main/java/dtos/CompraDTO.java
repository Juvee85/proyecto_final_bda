/*
 * CompraDTO.java
 */
package dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class CompraDTO {

    private String folio;

    private String nombreProveedor;

    private Float montoTotal;

    private LocalDateTime fecha;

    private List<DetalleCompraDTO> detalles;

    public CompraDTO() {
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<DetalleCompraDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompraDTO> detalles) {
        this.detalles = detalles;
    }

}
