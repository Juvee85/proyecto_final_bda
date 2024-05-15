/*
 * DetalleCompra.java
 */
package pojos;

import org.bson.types.ObjectId;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class DetalleCompra {

    private Integer cantidad;
    
    private Float costo;

    private ObjectId producto;

    public DetalleCompra() {
        
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public ObjectId getProducto() {
        return producto;
    }

    public void setProducto(ObjectId producto) {
        this.producto = producto;
    }
       
}
