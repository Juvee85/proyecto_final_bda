/*
 * VentaDTO.java
 */
package dtos;

import java.time.LocalDateTime;
import java.util.List;
import pojos.MetodoPago;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class VentaDTO {

    private String folio;
    
    private String nombreCliente;
    
    private String apellidoCliente;
    
    private MetodoPago metodoPago;
    
    private Float montoTotal;
    
    private LocalDateTime fecha;
    
    private UsuarioVentaDTO usuario;
    
    private List<DetalleVentaDTO> detalles ;

    public VentaDTO() {
    }

    public VentaDTO(String nombreCliente, String apellidoCliente, MetodoPago metodoPago, LocalDateTime fecha, UsuarioVentaDTO usuario, List<DetalleVentaDTO> detalles) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public UsuarioVentaDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVentaDTO usuario) {
        this.usuario = usuario;
    }

    public List<DetalleVentaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVentaDTO> detalles) {
        this.detalles = detalles;
    }
    
}
