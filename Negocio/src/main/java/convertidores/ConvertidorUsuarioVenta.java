/*
 * ConvertidorUsuarioVenta.java
 */
package convertidores;

import dtos.UsuarioVentaDTO;
import pojos.Usuario;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class ConvertidorUsuarioVenta extends Convertidor<UsuarioVentaDTO, Usuario>{

     public ConvertidorUsuarioVenta() {
        super(ConvertidorUsuarioVenta::convertToPojo, ConvertidorUsuarioVenta::convertToDto);
    }

    private static UsuarioVentaDTO convertToDto(Usuario usuario) {
        UsuarioVentaDTO dto = new UsuarioVentaDTO();
        dto.setRfc(usuario.getRfc());
        dto.setNombre(usuario.getNombre());
        dto.setApellidoPaterno(usuario.getApellidoPaterno());
        dto.setApellidoMaterno(usuario.getApellidoMaterno());
        
        return dto;
    }

    private static Usuario convertToPojo(UsuarioVentaDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        return usuario;
    }
}
