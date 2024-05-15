/*
 * ControlVentasBO.java
 */
package negocio;

import convertidores.ConvertidorVenta;
import daos.GestorVentas;
import dtos.DetalleVentaDTO;
import dtos.VentaDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IControlVentasBO;
import interfaces.IGestorVentas;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Venta;
import utilidades.GeneradorFolio;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ControlVentasBO implements IControlVentasBO {

    private final IGestorVentas GESTOR_VENTAS = GestorVentas.getInstance();

    @Override
    public void registrarVenta(VentaDTO venta) throws NegocioException {
        try {
            Float montoTotal = 0f;
            for (DetalleVentaDTO detalle : venta.getDetalles()) {
                montoTotal += detalle.getTotal();
            }
            venta.setMontoTotal(montoTotal);
            venta.setFolio("V" + GeneradorFolio.generarFolio());
            GESTOR_VENTAS.registrarVenta(new ConvertidorVenta().convertFromDto(venta));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            registrarVenta(venta);
        }
    }

    @Override
    public List<VentaDTO> obtenerVentas() throws NegocioException {
        try {
            List<Venta> consulta = GESTOR_VENTAS.consultarTodos();
            return new ConvertidorVenta().createFromPojos(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }
    
    @Override
    public VentaDTO obtenerVentaPorFolio(String folio) throws NegocioException {
        try {
            Venta consulta = GESTOR_VENTAS.consultarVenta(folio);
            return new ConvertidorVenta().convertFromPojo(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<VentaDTO> obtenerVentasDia() throws NegocioException {
        try {
            LocalDateTime hoy = LocalDateTime.now();
            int dia = hoy.getDayOfMonth();
            Month mes = hoy.getMonth();
            int anho = hoy.getYear();
            LocalDateTime inicioHoy = LocalDateTime.of(anho, mes, dia, 0, 0);
            LocalDateTime finalHoy= LocalDateTime.of(anho, mes, dia, 23, 59);
            
            List<Venta> consulta = GESTOR_VENTAS.consultarVentasPorPeriodo(inicioHoy, finalHoy);
            return new ConvertidorVenta().createFromPojos(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

}
