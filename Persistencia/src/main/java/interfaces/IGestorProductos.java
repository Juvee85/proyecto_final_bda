/*
 * IGestorProductos.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
import pojos.Producto;

/**
 * Define las operaciones basicas para el registro y consulta de
 * productos.
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorProductos {

    public List<Producto> consultarTodos() throws PersistenciaException;

    public List<Producto> consultarProductosConStock() throws PersistenciaException;

    public List<Producto> consultarProductosPorNombre(String nombreProducto) throws PersistenciaException;

    public void registrarProducto(Producto producto) throws PersistenciaException;

    public Producto consultarProducto(String codigoProducto) throws PersistenciaException;

    public Producto consultarProducto(ObjectId productoId) throws PersistenciaException;

    public void registrarCambioStock(ObjectId producto, int cantidad) throws PersistenciaException;
}
