/*
 * DetalleVentaDTO.java
 */
package dtos;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class DetalleVentaDTO {

    private String codigoProducto;

    private String nombreProducto;

    private Float precio;

    private Integer cantidad;

    private Float total;

    public DetalleVentaDTO() {
    }

    public DetalleVentaDTO(String codigoProducto, String nombreProducto, float precio, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        total = precio * cantidad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
