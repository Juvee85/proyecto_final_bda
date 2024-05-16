/*
 * IControlProductoBO.java
 */
package interfaces;

import dtos.ProductoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Juventino López García - 00000248547
 */
public interface IControlProductoBO {

    public ProductoDTO obtenerProductoPorCodigo(String codigo) throws NegocioException;

    public List<ProductoDTO> obtenerProductos() throws NegocioException;
    
    public List<ProductoDTO> obtenerProductosConStock() throws NegocioException;

    public void registrarProducto(ProductoDTO producto) throws NegocioException;
}
