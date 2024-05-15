/*
 * ConvertidorUsuario.java
 */
package convertidores;

import dtos.UsuarioDTO;
import excepciones.NegocioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Usuario;
import utilidades.Encriptador;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ConvertidorUsuario extends Convertidor<UsuarioDTO, Usuario> {

    public ConvertidorUsuario() {
        super(ConvertidorUsuario::convertToPojo, ConvertidorUsuario::convertToDto);
    }

    private static UsuarioDTO convertToDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setRfc(usuario.getRfc());
        dto.setNombre(usuario.getNombre());
        dto.setApellidoPaterno(usuario.getApellidoPaterno());
        dto.setApellidoMaterno(usuario.getApellidoMaterno());
        dto.setPuesto(usuario.getPuesto());
        dto.setTelefono(usuario.getTelefono());
        dto.setDireccion(new ConvertidorDireccion().convertFromPojo(usuario.getDireccion()));
        
        return dto;
    }

    private static Usuario convertToPojo(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setRfc(dto.getRfc());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        usuario.setPuesto(dto.getPuesto());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(new ConvertidorDireccion().convertFromDto(dto.getDireccion()));
        try {
            usuario.setContrasenha(Encriptador.encriptar(dto.getContrasenha()));
        } catch (NegocioException ex) {
            Logger.getLogger(ConvertidorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }

}
