/*
 * IGestorProveedores.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import pojos.Proveedor;

/**
 * Define las operaciones basicas para el subsistema de gestion de proveedores
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorProveedores {

    /**
     * Regresa todos los proveedores registrados en el sistema.
     *
     * @return
     * @throws PersistenciaException
     */
    public List<Proveedor> consultarTodos() throws PersistenciaException;

    /**
     * Regresa todos los proveedores que coincidan con el nombre especificado.
     *
     * @param nombre Nombre del proveeedor.
     * @return
     * @throws PersistenciaException
     */
    public List<Proveedor> consultarProveedoresPorNombre(String nombre) throws PersistenciaException;

    /**
     * Busca y regresa un proveedor a partir de su ID en el sistema.
     *
     * @param id ID del proveedor a buscar
     * @return
     * @throws PersistenciaException
     */
    public Proveedor consultarProveedor(Long id) throws PersistenciaException;

    /**
     * Busca y regresa un proveedor a partir de su numero telefonico.
     *
     * @param telefono Telefono del proveedor a buscar.
     * @return
     * @throws PersistenciaException
     */
    public Proveedor consultarProveedorPorNumeroTelefono(String telefono) throws PersistenciaException;

    /**
     * Registra un proveedor en el sistema.
     *
     * @param proveedor Informacion del proveedor a guardar.
     * @throws PersistenciaException
     */
    public void registrarProveedor(Proveedor proveedor) throws PersistenciaException;

    /**
     * Modifica la informacion de un proveedor en el sistema.
     *
     * @param proveedor Proveedor a modificar.
     * @throws PersistenciaException
     */
    public void actualizarProveedor(Proveedor proveedor) throws PersistenciaException;

    /**
     * Elimina a un proveedor a partir de su ID.
     *
     * @param id ID del proveedor a eliminar.
     * @throws PersistenciaException
     */
    public void eliminarProveedor(Long id) throws PersistenciaException;
}
