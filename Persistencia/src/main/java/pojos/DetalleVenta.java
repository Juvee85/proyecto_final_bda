/*
 * DetalleVenta.java
 */
package pojos;

import org.bson.types.ObjectId;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class DetalleVenta {

    private ObjectId id;

    private Integer cantidad;

    private ObjectId producto;
    
    public DetalleVenta() {
        
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ObjectId getProducto() {
        return producto;
    }

    public void setProducto(ObjectId producto) {
        this.producto = producto;
    }
    
    
}
