/*
 * Producto.java
 */
package pojos;

import java.time.LocalDate;
import org.bson.types.ObjectId;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class Producto {
    
    private ObjectId id;    
    
    private String nombre;
    
    private String codigo;
    
    private Float precio;
    
    private Integer stock;
    
    private Integer stockMinimo;
    
    private Integer stockExceso;
    
    private LocalDate fechaRegistro;
    
    private Boolean eliminado;

    public Producto() {
        
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getStockExceso() {
        return stockExceso;
    }

    public void setStockExceso(Integer stockExceso) {
        this.stockExceso = stockExceso;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
    
}
