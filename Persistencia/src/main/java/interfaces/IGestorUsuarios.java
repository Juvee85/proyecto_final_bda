/*
 * IGestorUsuarios.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
import pojos.Usuario;

/**
 * Define las operaciones basicas para el subsistema de Usuarios
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorUsuarios {

    /**
     * Busca y regresa un usuario con el ID especificado.
     *
     * @param id ID del usuario a buscar.
     * @return Usuario si se encuentra, null en caso contrario
     * @throws PersistenciaException En caso de error
     */
    public Usuario consultarUsuario(ObjectId id) throws PersistenciaException;

    public List<Usuario> consultarTodos() throws PersistenciaException;

    /**
     * Busca al usuario con el telefono especificado y lo regresa.
     *
     * @param telefono Telefono del usuario a buscar
     * @return Usuario si se encuentra, null en caso contrario
     * @throws PersistenciaException En caso de error.
     */
    public Usuario consultarUsuarioPorNumeroTelefono(String telefono) throws PersistenciaException;

    /**
     * Registra un usuario en el sistema (base de datos)
     *
     * @param usuario Usuario a registrar
     * @throws PersistenciaException En caso de que no se pueda registrar el
     * usuario
     */
    public void registrarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Modifica la informacion del usuario especificado en el sistema.
     *
     * @param usuario Usuario a modificar
     * @throws PersistenciaException En caso de que no se pueda actualizar los
     * datos del usuario
     */
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Elimina al usuario con el ID especificado en el sistema.
     *
     * @param id ID del usuario a eliminar.
     * @throws PersistenciaException En caso de que no se pueda eliminar el
     * usuario.
     */
    public void eliminarUsuario(ObjectId id) throws PersistenciaException;

    /**
     * Verifica si las credenciales de usuario proporcionadas coinciden con la
     * presente en el sistema y regresa al usuario con esas credenciales.
     *
     * @param telefono Telefono del usuario.
     * @param contrasenha Contrasena del usuario.
     * @return
     * @throws PersistenciaException En caso de cualquier error en el incio de
     * sesion del usuaro, telefono o contrasena incorrectos, errores internos,
     * etc.
     */
    public Usuario iniciarSesion(String telefono, String contrasenha) throws PersistenciaException;
}
