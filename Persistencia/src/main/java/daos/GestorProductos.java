/*
 * GestorProductos.java
 */
package daos;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import pojos.Producto;
import pojos.Proveedor;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorProductos implements IGestorProductos {

    private static GestorProductos instance;
    private final MongoCollection COLECCION_PRODUCTOS;

    private GestorProductos() {
        COLECCION_PRODUCTOS = ConexionBD.getDatabase().getCollection("productos", Producto.class);
        try {
            IndexOptions indexOptions = new IndexOptions().unique(true);
            COLECCION_PRODUCTOS.createIndex(Indexes.descending("codigo"), indexOptions);
        } catch (DuplicateKeyException e) {
        }
    }

    public static GestorProductos getInstance() {
        if (instance == null) {
            instance = new GestorProductos();
        }

        return instance;
    }

    @Override
    public List<Producto> consultarTodos() throws PersistenciaException {
        FindIterable<Producto> resultado = COLECCION_PRODUCTOS.find();
        ArrayList<Producto> productos = new ArrayList<>();
        for (Producto producto : resultado) {
            productos.add(producto);
        }
        return productos;
    }

    @Override
    public List<Producto> consultarProductosPorNombre(String nombreProducto) throws PersistenciaException {
        FindIterable<Producto> resultado = COLECCION_PRODUCTOS.find(eq("nombre", nombreProducto));
        ArrayList<Producto> productos = new ArrayList<>();
        for (Producto producto : resultado) {
            productos.add(producto);
        }
        return productos;
    }

    @Override
    public List<Producto> consultarProductosPorProveedor(Proveedor proveedor) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrarProducto(Producto producto) throws PersistenciaException {
        try {
             COLECCION_PRODUCTOS.insertOne(producto);
        } catch (MongoException e) {
            throw new PersistenciaException("Ya existe un producto registrado con este código, intente de nuevo con otro código");
        }
    }

    @Override
    public Producto consultarProducto(String codigoProducto) throws PersistenciaException {
        FindIterable<Producto> resultado = COLECCION_PRODUCTOS.find(eq("codigo", codigoProducto));
        return resultado.first();
    }

    @Override
    public Producto consultarProducto(ObjectId productoId) throws PersistenciaException {
        FindIterable<Producto> resultado = COLECCION_PRODUCTOS.find(eq("_id", productoId));
        return resultado.first();
    }

    @Override
    public void actualizarProducto(Producto producto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProducto(String codigoProducto) throws PersistenciaException {
        COLECCION_PRODUCTOS.updateOne(eq("codigo", codigoProducto), set("eliminado", true));
    }

    @Override
    public void registrarExistenciaProducto(ObjectId producto, int cantidad) throws PersistenciaException {
        COLECCION_PRODUCTOS.updateOne(eq("_id", producto), inc("stock", cantidad));
    }

    @Override
    public void eliminarInventarioProducto(String codigoProducto) throws PersistenciaException {
        COLECCION_PRODUCTOS.deleteOne(eq("codigo", codigoProducto));
    }

}
