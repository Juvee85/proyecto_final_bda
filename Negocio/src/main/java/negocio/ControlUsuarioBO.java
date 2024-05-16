/*
 * ControlUsuarioBO.java
 */
package negocio;

import convertidores.ConvertidorUsuario;
import daos.GestorUsuarios;
import dtos.UsuarioDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IControlUsuarioBO;
import interfaces.IGestorUsuarios;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Usuario;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ControlUsuarioBO implements IControlUsuarioBO {

    private final IGestorUsuarios GESTOR_USUARIOS = GestorUsuarios.getInstance();
    private final ConvertidorUsuario CONVERTIDOR = new ConvertidorUsuario();

    @Override
    public List<UsuarioDTO> obtenerUsuarios() throws NegocioException {
        try {
            List<Usuario> usuarios = GESTOR_USUARIOS.consultarTodos();
            return CONVERTIDOR.createFromPojos(usuarios);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlUsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public void registrarUsuario(UsuarioDTO usuarioDTO) throws NegocioException {
        try {
            Usuario usuario = CONVERTIDOR.convertFromDto(usuarioDTO);
            usuario.setFechaContratacion(LocalDate.now());
            GESTOR_USUARIOS.registrarUsuario(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlUsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

}
