/*
 * Compra.java
 */
package pojos;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * 
 * @author Juventino López García - 00000248547 
 */
public class Compra {

    private ObjectId id;
    
    private String folio;
    
    private Float montoTotal;
    
    private LocalDateTime fecha;
    
    private Proveedor proveedor;
    
    private List<DetalleCompra> detalles;

    public Compra() {
        
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }
    
}
