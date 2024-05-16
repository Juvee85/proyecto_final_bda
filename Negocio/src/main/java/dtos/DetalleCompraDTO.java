/*
 * DetalleCompraDTO.java
 */
package dtos;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class DetalleCompraDTO {

    private String codigoProducto;

    private String nombreProducto;

    private Integer cantidad;

    private Float total;

    public DetalleCompraDTO() {

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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
