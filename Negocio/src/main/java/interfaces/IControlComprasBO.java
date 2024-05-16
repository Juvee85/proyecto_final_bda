/*
 * IControlCompras.java
 */
package interfaces;

import dtos.CompraDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Juventino López García - 00000248547
 */
public interface IControlComprasBO {

    public void registrarCompra(CompraDTO venta) throws NegocioException;

    public List<CompraDTO> obtenerCompras() throws NegocioException;
    
    public CompraDTO obtenerCompraPorFolio(String folio) throws NegocioException;
}
