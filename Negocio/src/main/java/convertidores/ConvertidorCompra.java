/*
 * ConvertidorCompra.java
 */
package convertidores;

import dtos.CompraDTO;
import pojos.Compra;
import pojos.Proveedor;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ConvertidorCompra extends Convertidor<CompraDTO, Compra> {

    public ConvertidorCompra() {
        super(ConvertidorCompra::convertToPojo, ConvertidorCompra::convertToDto);
    }

    private static CompraDTO convertToDto(Compra compra) {
        CompraDTO dto = new CompraDTO();
        dto.setNombreProveedor(compra.getProveedor().getNombre());
        dto.setFecha(compra.getFecha());
        dto.setMontoTotal(compra.getMontoTotal());
        dto.setFolio(compra.getFolio());
        dto.setDetalles(new ConvertidorDetalleCompra().createFromPojos(compra.getDetalles()));

        return dto;
    }

    private static Compra convertToPojo(CompraDTO dto) {
        Compra compra = new Compra();
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(dto.getNombreProveedor());
        compra.setProveedor(proveedor);
        compra.setFecha(dto.getFecha());
        compra.setMontoTotal(dto.getMontoTotal());
        compra.setDetalles(new ConvertidorDetalleCompra().createFromDtos(dto.getDetalles()));
        compra.setFolio(dto.getFolio());

        return compra;
    }
}
