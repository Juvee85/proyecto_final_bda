/*
 * ProductoDTO.java
 */
package dtos;

/**
 * 
 * @author Juventino López García - 00000248547 
 */
public class ProductoDTO {

    private String nombre;
    
    private String codigo;
    
    private Float precio;
    
    private Integer stock;
    
    private Integer stockMinimo;
    
    private Integer stockExceso;

    public ProductoDTO() {
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
    
}
