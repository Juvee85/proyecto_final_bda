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

    private Integer cantidad;

    private float total;
    
    private ObjectId producto;
    
    public DetalleVenta() {
        
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
    public ObjectId getProducto() {
        return producto;
    }

    public void setProducto(ObjectId producto) {
        this.producto = producto;
    }
    
    
}
