/*
 * ConvertidorVenta.java
 */
package convertidores;

import dtos.UsuarioVentaDTO;
import dtos.VentaDTO;
import pojos.Usuario;
import pojos.Venta;

/**
 *
 * @author Juventino López García - 00000248547 - 13/05/2024
 */
public class ConvertidorVenta extends Convertidor<VentaDTO, Venta> {

    public ConvertidorVenta() {
        super(ConvertidorVenta::convertToPojo, ConvertidorVenta::convertToDto);
    }

    private static VentaDTO convertToDto(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setNombreCliente(venta.getNombreCliente());
        dto.setApellidoCliente(venta.getApellidoCliente());
        dto.setFecha(venta.getFecha());
        dto.setMetodoPago(venta.getMetodoPago());
        dto.setMontoTotal(venta.getMontoTotal());
        dto.setFolio(venta.getFolio());
        UsuarioVentaDTO usuarioDTO = new UsuarioVentaDTO();
        Usuario usuario = venta.getUsuario();
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
        dto.setUsuario(usuarioDTO);
        dto.setDetalles(new ConvertidorDetalleVenta().createFromPojos(venta.getDetalles()));

        return dto;
    }

    private static Venta convertToPojo(VentaDTO dto) {
        Venta venta = new Venta();
        venta.setNombreCliente(dto.getNombreCliente());
        venta.setApellidoCliente(dto.getApellidoCliente());
        venta.setFecha(dto.getFecha());
        venta.setMetodoPago(dto.getMetodoPago());
        venta.setMontoTotal(dto.getMontoTotal());
        venta.setDetalles(new ConvertidorDetalleVenta().createFromDtos(dto.getDetalles()));
        venta.setUsuario(new ConvertidorUsuarioVenta().convertFromDto(dto.getUsuario()));
        venta.setFolio(dto.getFolio());

        return venta;
    }
}
