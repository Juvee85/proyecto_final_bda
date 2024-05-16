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
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Producto;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ControlProductosBO implements IControlProductoBO {

    private final IGestorProductos GESTOR_PRODUCTOS = GestorProductos.getInstance();

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

    @Override
    public List<ProductoDTO> obtenerProductosConStock() throws NegocioException {
        try {
            List<Producto> consulta = GESTOR_PRODUCTOS.consultarProductosConStock();

            return new ConvertidorProducto().createFromPojos(consulta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlProductosBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public void registrarProducto(ProductoDTO dto) throws NegocioException {
        try {
            Producto producto = new ConvertidorProducto().convertFromDto(dto);
            producto.setStock(0);
            producto.setFechaRegistro(LocalDate.now());
            GESTOR_PRODUCTOS.registrarProducto(producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ControlProductosBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

}
