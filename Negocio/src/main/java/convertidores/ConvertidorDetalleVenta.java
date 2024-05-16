/*
 * ConvertidorDetalleVenta.java
 */
package convertidores;

import daos.GestorProductos;
import dtos.DetalleVentaDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.DetalleVenta;
import pojos.Producto;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ConvertidorDetalleVenta extends Convertidor<DetalleVentaDTO, DetalleVenta> {

    public ConvertidorDetalleVenta() {
        super(ConvertidorDetalleVenta::convertToPojo, ConvertidorDetalleVenta::convertToDto);
    }

    private static DetalleVentaDTO convertToDto(DetalleVenta detalleVenta) {
        DetalleVentaDTO dto = new DetalleVentaDTO();
        Producto producto = null;
        try {
            producto = GestorProductos.getInstance().consultarProducto(detalleVenta.getProducto());
            dto.setCodigoProducto(producto.getCodigo());
            dto.setNombreProducto(producto.getNombre());
            dto.setPrecio(producto.getPrecio());
            dto.setCantidad(detalleVenta.getCantidad());
            dto.setTotal(detalleVenta.getTotal());
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConvertidorDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dto;
    }

    private static DetalleVenta convertToPojo(DetalleVentaDTO dto) {
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setCantidad(dto.getCantidad());
        detalleVenta.setTotal(dto.getTotal());
        try {
            detalleVenta.setProducto(GestorProductos.getInstance().consultarProducto(dto.getCodigoProducto()).getId());
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConvertidorDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detalleVenta;
    }
}
