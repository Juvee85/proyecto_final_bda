/*
 * GestorCompras.java
 */
package daos;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lt;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IGestorCompras;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import pojos.Compra;
import pojos.DetalleCompra;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorCompras implements IGestorCompras {

    private static GestorCompras instance;
    private final MongoCollection COLECCION_COMPRAS;

    private GestorCompras() {
        COLECCION_COMPRAS = ConexionBD.getDatabase().getCollection("compras", Compra.class);
        try {
            IndexOptions indexOptions = new IndexOptions().unique(true);
            
            COLECCION_COMPRAS.createIndex(Indexes.descending("folio"), indexOptions);
        } catch (DuplicateKeyException e) {
        }
    }

    public static GestorCompras getInstance() {
        if (instance == null) {
            instance = new GestorCompras();
        }

        return instance;
    }

    @Override
    public Compra consultarCompra(String folio) throws PersistenciaException {
        FindIterable<Compra> resultado = COLECCION_COMPRAS.find(eq("folio", folio));

        return resultado.first();
    }

    @Override
    public List<Compra> consultarComprasAProveedor(Long usuarioId) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Compra> consultarComprasPorPeriodo(LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException {
        FindIterable<Compra> resultado = COLECCION_COMPRAS.find(
        and(gt("fecha", inicio), lt("fecha", fin)));
        ArrayList<Compra> ventas = new ArrayList<>();
        for (Compra compra : resultado) {
            ventas.add(compra);
        }
        return ventas;
    }

    @Override
    public List<Compra> consultarTodos() throws PersistenciaException {
        FindIterable<Compra> resultado = COLECCION_COMPRAS.find();
        ArrayList<Compra> ventas = new ArrayList<>();
        for (Compra compra : resultado) {
            ventas.add(compra);
        }
        return ventas;
    }

    @Override
    public void registrarCompra(Compra compra) throws PersistenciaException {
        try {
            GestorProductos gestor = GestorProductos.getInstance();
            for (DetalleCompra detalle : compra.getDetalles()) {
                gestor.registrarExistenciaProducto(detalle.getProducto(),
                        detalle.getCantidad());
            }
            COLECCION_COMPRAS.insertOne(compra);
        } catch (MongoWriteException e) {
            throw new PersistenciaException("Error al registrar la venta");
        }
    }

    @Override
    public void actualizarCompra(Compra compra) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarCompra(ObjectId compraId) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
