/*
 * GestorUsuarios.java
 */
package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IGestorUsuarios;
import pojos.Usuario;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorUsuarios implements IGestorUsuarios {

    private static GestorUsuarios instance;
    private final MongoCollection coleccionUsuarios;

    /**
     * Crea una instancia del subsistema Usuarios
     */
    private GestorUsuarios() {
        coleccionUsuarios = ConexionBD.getDatabase().getCollection("usuarios", Usuario.class);
    }

    /**
     * Regresa la instancia del gestor de usuarios
     *
     * @return La unica instancia del gestor de usuarios de la aplicacion
     */
    public static GestorUsuarios getnstance() {
        if (instance == null) {
            instance = new GestorUsuarios();
        }

        return instance;
    }

    @Override
    public Usuario consultarUsuario(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public Usuario consultarUsuarioPorNumeroTelefono(String telefono) throws PersistenciaException {
        FindIterable<Usuario> usuarios = coleccionUsuarios.find(eq("telefono", telefono));

        return usuarios.first();
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            coleccionUsuarios.insertOne(usuario);
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrio un error al registrar el usuario");
        }

    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public void eliminarUsuario(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario iniciarSesion(String telefono, String contrasena) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
