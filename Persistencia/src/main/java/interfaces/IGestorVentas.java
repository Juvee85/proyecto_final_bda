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

    public Venta consultarVenta(String folio) throws PersistenciaException;

    public List<Venta> consultarVentasPorPeriodo(LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException;

    public List<Venta> consultarTodos() throws PersistenciaException;

    public void registrarVenta(Venta venta) throws PersistenciaException;

}
