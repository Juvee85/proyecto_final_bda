/*
 * ControlComprasBO.java
 */
package negocio;

import convertidores.ConvertidorCompra;
import daos.GestorCompras;
import dtos.CompraDTO;
import dtos.DetalleCompraDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IControlComprasBO;
import interfaces.IGestorCompras;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Compra;
import utilidades.GeneradorFolio;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ControlComprasBO implements IControlComprasBO {

    private final IGestorCompras GESTOR_COMPRAS = GestorCompras.getInstance();

    @Override
    public void registrarCompra(CompraDTO compra) throws NegocioException {
        try {
            float montoTotal = 0f;
            for (DetalleCompraDTO detalle : compra.getDetalles()) {
                montoTotal += detalle.getTotal();
            }
            compra.setMontoTotal(montoTotal);
            compra.setFolio("C" + GeneradorFolio.generarFolio());
            GESTOR_COMPRAS.registrarCompra(new ConvertidorCompra().convertFromDto(compra));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<CompraDTO> obtenerCompras() throws NegocioException {
        try {
            List<Compra> consulta = GESTOR_COMPRAS.consultarTodos();
            return new ConvertidorCompra().createFromPojos(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public CompraDTO obtenerCompraPorFolio(String folio) throws NegocioException {
        try {
            Compra consulta = GESTOR_COMPRAS.consultarCompra(folio);
            return new ConvertidorCompra().convertFromPojo(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

}
