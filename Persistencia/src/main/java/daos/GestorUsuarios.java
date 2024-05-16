/*
 * GestorUsuarios.java
 */
package daos;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Usuario;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorUsuarios implements IGestorUsuarios {

    private static GestorUsuarios instance;
    private final MongoCollection COLECCION_USUARIOS;

    private GestorUsuarios() {
        COLECCION_USUARIOS = ConexionBD.getDatabase().getCollection("usuarios", Usuario.class);
        try {
            IndexOptions indexOptions = new IndexOptions().unique(true);
            COLECCION_USUARIOS.createIndex(Indexes.descending("telefono"), indexOptions);
            COLECCION_USUARIOS.createIndex(Indexes.descending("rfc"), indexOptions);

        } catch (DuplicateKeyException e) {
        }
    }

    public static GestorUsuarios getInstance() {
        if (instance == null) {
            instance = new GestorUsuarios();
        }

        return instance;
    }

    @Override
    public Usuario consultarUsuario(String rfc) throws PersistenciaException {
        try {
            FindIterable<Usuario> usuarios = COLECCION_USUARIOS.find(eq("_id", rfc));

            return usuarios.first();
        } catch (Exception e) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Error al obtener al usuario");
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
        try {
            FindIterable<Usuario> resultado = COLECCION_USUARIOS.find();
            ArrayList<Usuario> usuarios = new ArrayList<>();
            for (Usuario usuario : resultado) {
                usuarios.add(usuario);
            }

            return usuarios;
        } catch (Exception e) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Error al obtener a los usuarios");
        }
    }

    @Override
    public Usuario consultarUsuarioPorNumeroTelefono(String telefono) throws PersistenciaException {
        try {
            FindIterable<Usuario> usuarios = COLECCION_USUARIOS.find(eq("telefono", telefono));
            return usuarios.first();
        } catch (Exception e) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Error al obtener al usuario");
        }
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            COLECCION_USUARIOS.insertOne(usuario);
        } catch (Exception e) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Ya está registrado un usuario con los datos dados, intenta Ingresar un RFC, o telefono diferente");
        }
    }

    @Override
    public Usuario iniciarSesion(String telefono, String contrasenha) throws PersistenciaException {
        try {
            FindIterable<Usuario> usuarios = COLECCION_USUARIOS.find(and(eq("telefono", telefono), eq("contrasenha", contrasenha)));

            return usuarios.first();
        } catch (Exception e) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Error al iniciar sesion");
        }
    }
}