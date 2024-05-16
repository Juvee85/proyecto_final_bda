/*
 * ConvertidorDetalleCompra.java
 */
package convertidores;

import daos.GestorProductos;
import dtos.DetalleCompraDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.DetalleCompra;
import pojos.Producto;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ConvertidorDetalleCompra extends Convertidor<DetalleCompraDTO, DetalleCompra> {

    public ConvertidorDetalleCompra() {
        super(ConvertidorDetalleCompra::convertToPojo, ConvertidorDetalleCompra::convertToDto);
    }

    private static DetalleCompraDTO convertToDto(DetalleCompra detalleCompra) {
        DetalleCompraDTO dto = new DetalleCompraDTO();
        Producto producto = null;
        try {
            producto = GestorProductos.getInstance().consultarProducto(detalleCompra.getProducto());
            dto.setCodigoProducto(producto.getCodigo());
            dto.setNombreProducto(producto.getNombre());
            dto.setCantidad(detalleCompra.getCantidad());
            dto.setTotal(detalleCompra.getCosto());
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConvertidorDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dto;
    }

    private static DetalleCompra convertToPojo(DetalleCompraDTO dto) {
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCantidad(dto.getCantidad());
        detalleCompra.setCosto(dto.getTotal());
        try {
            detalleCompra.setProducto(GestorProductos.getInstance().consultarProducto(dto.getCodigoProducto()).getId());
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConvertidorDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detalleCompra;
    }
}
