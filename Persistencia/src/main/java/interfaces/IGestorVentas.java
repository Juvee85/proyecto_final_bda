/*
 * IGestorVentas.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.util.List;
import pojos.Venta;

/**
 * Define las operaciones basicas para gestionar ventas en el sistema.
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorVentas {

    /**
     * Busca una venta a partir de su ID.
     *
     * @param folio numero identificador de la venta.
     * @return Venta si se encuentra, null en caso contrario.
     * @throws PersistenciaException
     */
    public Venta consultarVenta(String folio) throws PersistenciaException;

    /**
     * Regresa una lista de las ventas hechas por el usuario con el ID
     * especificado.
     *
     * @param usuarioId ID del usuario
     * @return
     * @throws PersistenciaException
     */
    public List<Venta> consultarVentasDeUsuario(Long usuarioId) throws PersistenciaException;

    /**
     * Regresa una lista de ventas en el periodo especificado.
     *
     * @param inicio Inicio del periodo.
     * @param fin Fin del periodo
     * @return
     * @throws PersistenciaException
     */
    public List<Venta> consultarVentasPorPeriodo(LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException;

    /**
     * Regresa una lista con todas las ventas existentes.
     *
     * @return
     * @throws PersistenciaException
     */
    public List<Venta> consultarTodos() throws PersistenciaException;

    /**
     * Registra una nueva venta.
     *
     * @param venta Venta a guardar.
     * @throws PersistenciaException
     */
    public void registrarVenta(Venta venta) throws PersistenciaException;

    /**
     * Modifica la informacion de la venta en cuestion.
     *
     * @param venta Venta a modificar.
     * @throws PersistenciaException
     */
    public void actualizarVenta(Venta venta) throws PersistenciaException;

    /**
     * Elimina una venta con el ID de la venta especificado.
     *
     * @param ventaId ID de la venta a eliminar.
     * @throws PersistenciaException
     */
    public void eliminarVenta(Long ventaId) throws PersistenciaException;
}
