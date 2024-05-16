/*
 * ControlVentasBO.java
 */
package negocio;

import convertidores.ConvertidorVenta;
import daos.GestorProductos;
import daos.GestorVentas;
import dtos.DetalleVentaDTO;
import dtos.VentaDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IControlVentasBO;
import interfaces.IGestorProductos;
import interfaces.IGestorVentas;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Producto;
import pojos.Venta;
import utilidades.GeneradorFolio;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ControlVentasBO implements IControlVentasBO {

    private final IGestorVentas GESTOR_VENTAS = GestorVentas.getInstance();
    private final IGestorProductos GESTOR_PRODUCTOS = GestorProductos.getInstance();
    private final ConvertidorVenta CONVERTIDOR = new ConvertidorVenta();

    @Override
    public void registrarVenta(VentaDTO venta) throws NegocioException {
        try {
            float montoTotal = 0f;
            for (DetalleVentaDTO detalle : venta.getDetalles()) {
                Producto producto = GESTOR_PRODUCTOS.consultarProducto(detalle.getCodigoProducto());

                if (producto.getStock() - detalle.getCantidad() < 0) {
                    throw new NegocioException("No cuenta con suficiente stock para terminar la venta");
                }

                montoTotal += detalle.getTotal();
            }
            venta.setMontoTotal(montoTotal);
            venta.setFolio("V" + GeneradorFolio.generarFolio());
            GESTOR_VENTAS.registrarVenta(CONVERTIDOR.convertFromDto(venta));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            // Falla el registro si se le asigna al azar un folio repetido, y lo vuelve a intentar
            registrarVenta(venta);
        }
    }

    @Override
    public List<VentaDTO> obtenerVentas() throws NegocioException {
        try {
            List<Venta> consulta = GESTOR_VENTAS.consultarTodos();
            return CONVERTIDOR.createFromPojos(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public VentaDTO obtenerVentaPorFolio(String folio) throws NegocioException {
        try {
            Venta consulta = GESTOR_VENTAS.consultarVenta(folio);
            return CONVERTIDOR.convertFromPojo(consulta);
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
            LocalDateTime inicioHoy = LocalDateTime.of(anho, mes, dia, 0, 0, 0);
            LocalDateTime finalHoy = LocalDateTime.of(anho, mes, dia, 23, 59, 59);

            List<Venta> consulta = GESTOR_VENTAS.consultarVentasPorPeriodo(inicioHoy, finalHoy);
            return CONVERTIDOR.createFromPojos(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlVentasBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

}
