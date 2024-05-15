/*
 * ConvertidorProducto.java
 */
package convertidores;

import dtos.ProductoDTO;
import pojos.Producto;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class ConvertidorProducto extends Convertidor<ProductoDTO, Producto> {

    public ConvertidorProducto() {
        super(ConvertidorProducto::convertToPojo, ConvertidorProducto::convertToDto);
    }

    private static ProductoDTO convertToDto(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setCodigo(producto.getCodigo());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setStockExceso(producto.getStockExceso());
        dto.setStockMinimo(producto.getStockMinimo());
        return dto;
    }

    private static Producto convertToPojo(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setStockExceso(dto.getStockExceso());
        producto.setStockMinimo(dto.getStockMinimo());
        return producto;
    }
}
