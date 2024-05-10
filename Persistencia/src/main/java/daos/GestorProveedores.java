/*
 * GestorProveedores.java
 */
package daos;

import com.mongodb.client.MongoCollection;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IGestorProveedores;
import java.util.List;
import pojos.Proveedor;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorProveedores implements IGestorProveedores {

    private static GestorProveedores instance;
    private final MongoCollection coleccionProveedores;

    private GestorProveedores() {
        coleccionProveedores = ConexionBD.getDatabase().getCollection("proveedores", Proveedor.class);
    }

    public static GestorProveedores getnstance() {
        if (instance == null) {
            instance = new GestorProveedores();
        }

        return instance;
    }

    @Override
    public List<Proveedor> consultarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proveedor> consultarProveedoresPorNombre(String nombre) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proveedor consultarProveedor(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proveedor consultarProveedorPorNumeroTelefono(String telefono) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrarProveedor(Proveedor proveedor) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProveedor(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
