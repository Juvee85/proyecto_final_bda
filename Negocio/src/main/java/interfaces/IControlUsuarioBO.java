/*
 * IControlUsuarioBO.java
 */
package interfaces;

import dtos.UsuarioDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Juventino López García - 00000248547
 */
public interface IControlUsuarioBO {

    public List<UsuarioDTO> obtenerUsuarios() throws NegocioException;
    
    public void registrarUsuario(UsuarioDTO usuario) throws NegocioException;
}
