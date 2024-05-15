/*
 * IniciarSesion.java
 */
package negocio;

import convertidores.ConvertidorUsuario;
import daos.GestorUsuarios;
import dtos.UsuarioDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IGestorUsuarios;
import interfaces.IIniciarSesionBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Usuario;
import utilidades.Encriptador;

/**
 * Objeto de negocio para el inicio de sesión
 *
 * @author Juventino López García - 00000248547
 */
public class IniciarSesionBO implements IIniciarSesionBO {

    private final IGestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();

    @Override
    public UsuarioDTO iniciarSesion(String telefono, String contrasenha) throws NegocioException {
        try {
            Usuario usuario = gestorUsuarios.iniciarSesion(telefono, Encriptador.encriptar(contrasenha));

            if (usuario == null) {
                throw new NegocioException("Las credenciales ingresadas no coinciden, intente de nuevo");
            }

            ConvertidorUsuario convertidorUsuario = new ConvertidorUsuario();
            
            return convertidorUsuario.convertFromPojo(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(IniciarSesionBO.class.getName()).log(Level.SEVERE, null, ex);

            throw new NegocioException(ex.getMessage());
        }
    }

}
