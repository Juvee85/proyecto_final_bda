/*
 * IGestorCompras.java
 */
package interfaces;

import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.util.List;
import pojos.Compra;

/**
 *
 * @author Juventino López García - 00000248547
 */
public interface IGestorCompras {

    public Compra consultarCompra(String folio) throws PersistenciaException;

    public List<Compra> consultarComprasPorPeriodo(LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException;

    public List<Compra> consultarTodos() throws PersistenciaException;

    public void registrarCompra(Compra compra) throws PersistenciaException;

}
