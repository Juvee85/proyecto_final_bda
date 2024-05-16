/*
 * IGestorProductos.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
import pojos.Producto;
import pojos.Proveedor;

/**
 * Define las operaciones basicas para el registro, modificacion y consulta de
 * productos.
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorProductos {

    /**
     * Regresa una lista con todos los productos registrados en el sistema
     *
     * @return
     * @throws PersistenciaException
     */
    public List<Producto> consultarTodos() throws PersistenciaException;

    /**
     * Regresa una lista con productos en donde sus nombres coinciden con pasado
     * en el nombre dado como parametro.
     *
     * @param nombreProducto Nombre del producto a buscar
     * @return
     * @throws PersistenciaException
     */
    public List<Producto> consultarProductosPorNombre(String nombreProducto) throws PersistenciaException;

    /**
     * Regresa una lista de productos que son suministrados por el proveedor
     * pasado como parametro
     *
     * @param proveedor Proveedor de los productos a buscar
     * @return
     * @throws PersistenciaException
     */
    public List<Producto> consultarProductosPorProveedor(Proveedor proveedor) throws PersistenciaException;

    /**
     * Registra un producto en el sistema.
     *
     * @param producto Producto a registrar
     * @throws PersistenciaException
     */
    public void registrarProducto(Producto producto) throws PersistenciaException;

    /**
     * Regresa el producto con el codigo especificado.
     *
     * @param codigoProducto Codigo de producto (sistema)
     * @return Producto si se encuentra, null en caso contrario.
     * @throws PersistenciaException
     */
    public Producto consultarProducto(String codigoProducto) throws PersistenciaException;

    /**
     * Obtiene un producto con el id del producto (codigo barras)
     *
     * @param productoId ID del producto (codigo barras)
     * @return Producto si se encuentra, null en caso contrario.
     * @throws PersistenciaException
     */
    public Producto consultarProducto(ObjectId productoId) throws PersistenciaException;

    /**
     * Actualiza la informacion del producto dado.
     *
     * @param producto Producto que se modificara
     * @throws PersistenciaException
     */
    public void actualizarProducto(Producto producto) throws PersistenciaException;

    /**
     * Elimina el producto del sistema usando su codigo interno (sistema).
     *
     * @param codigoProducto Codigo interno del producto (codigo sistema)
     * @throws PersistenciaException
     */
    public void eliminarProducto(String codigoProducto) throws PersistenciaException;
    
    /**
     * Registra la cantida unidades del producto especificado en el inventario.
     *
     * @param producto Producto a actualizar su existencia.
     * @param cantidad Cantidad del producto a registrar.
     * @throws PersistenciaException en caso de error.
     */
    public void registrarExistenciaProducto(ObjectId producto, int cantidad) throws PersistenciaException;

    /**
     * Elimina todo registro y existencia del producto en el inventario de
     * productos.
     *
     * @param codigoProducto
     * @throws PersistenciaException subsistemas.excepciones.DAOException
     */
    public void eliminarInventarioProducto(String codigoProducto) throws PersistenciaException;
}
