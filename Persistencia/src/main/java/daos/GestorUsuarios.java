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
import org.bson.types.ObjectId;
import pojos.Usuario;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorUsuarios implements IGestorUsuarios {

    private static GestorUsuarios instance;
    private final MongoCollection COLECCION_USUARIOS;

    /**
     * Crea una instancia del subsistema Usuarios
     */
    private GestorUsuarios() {
        COLECCION_USUARIOS = ConexionBD.getDatabase().getCollection("usuarios", Usuario.class);
        try {
            IndexOptions indexOptions = new IndexOptions().unique(true);
            COLECCION_USUARIOS.createIndex(Indexes.descending("telefono"), indexOptions);
        } catch (DuplicateKeyException e) {
            System.out.printf("duplicate field values encountered, couldn't create index: \t%s\n", e);
        }
    }

    /**
     * Regresa la instancia del gestor de usuarios
     *
     * @return La unica instancia del gestor de usuarios de la aplicacion
     */
    public static GestorUsuarios getInstance() {
        if (instance == null) {
            instance = new GestorUsuarios();
        }

        return instance;
    }

    @Override
    public Usuario consultarUsuario(ObjectId id) throws PersistenciaException {
        FindIterable<Usuario> usuarios = COLECCION_USUARIOS.find(eq("_id", id));

        return usuarios.first();

    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
        FindIterable<Usuario> resultado = COLECCION_USUARIOS.find();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Usuario usuario : resultado) {
            usuarios.add(usuario);
        }

        return usuarios;
    }

    @Override
    public Usuario consultarUsuarioPorNumeroTelefono(String telefono) throws PersistenciaException {
        FindIterable<Usuario> usuarios = COLECCION_USUARIOS.find(eq("telefono", telefono));

        return usuarios.first();
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            COLECCION_USUARIOS.insertOne(usuario);
        } catch (Exception e) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Ya está registrado un usuario con el RFC dado");
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException {
        COLECCION_USUARIOS.updateOne(eq("_id", usuario.getId()), usuario.toDocument());
    }

    @Override
    public void eliminarUsuario(ObjectId id) throws PersistenciaException {
        COLECCION_USUARIOS.deleteOne(eq("_id", id));
    }

    @Override
    public Usuario iniciarSesion(String telefono, String contrasenha) throws PersistenciaException {
        FindIterable<Usuario> usuarios = COLECCION_USUARIOS.find(and(eq("telefono", telefono), eq("contrasenha", contrasenha)));

        return usuarios.first();
    }

}
