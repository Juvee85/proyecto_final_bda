/*
 * IControlVentasBO.java
 */
package interfaces;

import dtos.VentaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Juventino López García - 00000248547
 */
public interface IControlVentasBO {

    public void registrarVenta(VentaDTO venta) throws NegocioException;
    
    public List<VentaDTO> obtenerVentas() throws NegocioException;
    
    public List<VentaDTO> obtenerVentasDia() throws NegocioException;
    
    public VentaDTO obtenerVentaPorFolio(String folio) throws NegocioException;
}
