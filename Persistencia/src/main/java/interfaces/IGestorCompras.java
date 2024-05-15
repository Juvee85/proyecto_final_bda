/*
 * IGestorCompras.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;
import pojos.Compra;

/**
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorCompras {

    /**
     * Busca una venta a partir de su ID.
     *
     * @param id numero identificador de la venta.
     * @return Venta si se encuentra, null en caso contrario.
     * @throws PersistenciaException
     */
    public Compra consultarCompra(ObjectId id) throws PersistenciaException;

    /**
     * Regresa una lista de las ventas hechas por el usuario con el ID
     * especificado.
     *
     * @param usuarioId ID del usuario
     * @return
     * @throws PersistenciaException
     */
    public List<Compra> consultarComprasAProveedor(Long usuarioId) throws PersistenciaException;

    /**
     * Regresa una lista de ventas en el periodo especificado.
     *
     * @param inicio Inicio del periodo.
     * @param fin Fin del periodo
     * @return
     * @throws PersistenciaException
     */
    public List<Compra> consultarComprasPorPeriodo(LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException;

    /**
     * Regresa una lista con todas las ventas existentes.
     *
     * @return
     * @throws PersistenciaException
     */
    public List<Compra> consultarTodos() throws PersistenciaException;

    /**
     * Registra una nueva venta.
     *
     * @param venta Venta a guardar.
     * @throws PersistenciaException
     */
    public void registrarCompra(Compra venta) throws PersistenciaException;

    /**
     * Modifica la informacion de la venta en cuestion.
     *
     * @param venta Venta a modificar.
     * @throws PersistenciaException
     */
    public void actualizarCompra(Compra venta) throws PersistenciaException;

    /**
     * Elimina una venta con el ID de la venta especificado.
     *
     * @param ventaId ID de la venta a eliminar.
     * @throws PersistenciaException
     */
    public void eliminarCompra(ObjectId ventaId) throws PersistenciaException;
}
