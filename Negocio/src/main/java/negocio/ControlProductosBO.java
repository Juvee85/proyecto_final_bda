/*
 * ControlProductosBO.java
 */
package negocio;

import convertidores.ConvertidorProducto;
import daos.GestorProductos;
import dtos.ProductoDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IControlProductoBO;
import interfaces.IGestorProductos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Producto;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ControlProductosBO implements IControlProductoBO {

    private final IGestorProductos GESTOR_PRODUCTOS = GestorProductos.getnstance();

    @Override
    public ProductoDTO obtenerProductoPorCodigo(String codigo) throws NegocioException {
        try {
            Producto producto = GESTOR_PRODUCTOS.consultarProducto(codigo);
            
            return new ConvertidorProducto().convertFromPojo(producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlProductosBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        try {
            List<Producto> consulta = GESTOR_PRODUCTOS.consultarTodos();

            return new ConvertidorProducto().createFromPojos(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlProductosBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

}
