/*
 * GestorVentas.java
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
import interfaces.IGestorVentas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pojos.DetalleVenta;
import pojos.Venta;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorVentas implements IGestorVentas {

    private static GestorVentas instance;
    private final MongoCollection COLECCION_VENTAS;

    private GestorVentas() {
        COLECCION_VENTAS = ConexionBD.getDatabase().getCollection("ventas", Venta.class);
        try {
            IndexOptions indexOptions = new IndexOptions().unique(true);
            COLECCION_VENTAS.createIndex(Indexes.descending("folio"), indexOptions);
        } catch (DuplicateKeyException e) {
        }
    }

    public static GestorVentas getInstance() {
        if (instance == null) {
            instance = new GestorVentas();
        }

        return instance;
    }

    @Override
    public Venta consultarVenta(String folio) throws PersistenciaException {
        try {
            FindIterable<Venta> resultado = COLECCION_VENTAS.find(eq("folio", folio));

            return resultado.first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la venta");
        }

    }

    @Override
    public List<Venta> consultarVentasPorPeriodo(LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException {
        try {
            FindIterable<Venta> resultado = COLECCION_VENTAS.find(
                    and(gt("fecha", inicio), lt("fecha", fin)));
            ArrayList<Venta> ventas = new ArrayList<>();
            for (Venta venta : resultado) {
                ventas.add(venta);
            }

            return ventas;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las ventas");
        }
    }

    @Override
    public List<Venta> consultarTodos() throws PersistenciaException {
        try {
            FindIterable<Venta> resultado = COLECCION_VENTAS.find();
            ArrayList<Venta> ventas = new ArrayList<>();
            for (Venta venta : resultado) {
                ventas.add(venta);
            }

            return ventas;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las ventas");
        }
    }

    @Override
    public void registrarVenta(Venta venta) throws PersistenciaException {
        try {
            GestorProductos gestor = GestorProductos.getInstance();
            for (DetalleVenta detalle : venta.getDetalles()) {
                gestor.registrarCambioStock(detalle.getProducto(),
                        -detalle.getCantidad());
            }
            COLECCION_VENTAS.insertOne(venta);
        } catch (MongoWriteException e) {
            throw new PersistenciaException("Error al registrar la venta");
        }
    }
}
