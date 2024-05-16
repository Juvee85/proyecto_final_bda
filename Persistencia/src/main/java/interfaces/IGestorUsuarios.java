/*
 * IGestorUsuarios.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import pojos.Usuario;

/**
 * Define las operaciones basicas para el subsistema de Usuarios
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorUsuarios {

    public Usuario consultarUsuario(String rfc) throws PersistenciaException;

    public List<Usuario> consultarTodos() throws PersistenciaException;

    public Usuario consultarUsuarioPorNumeroTelefono(String telefono) throws PersistenciaException;

    public void registrarUsuario(Usuario usuario) throws PersistenciaException;

    public Usuario iniciarSesion(String telefono, String contrasenha) throws PersistenciaException;
}
