/*
 * GestorVentas.java
 */
package daos;

import com.mongodb.client.MongoCollection;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IGestorVentas;
import java.time.LocalDateTime;
import java.util.List;
import pojos.Venta;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class GestorVentas implements IGestorVentas {

    private static GestorVentas instance;
    private final MongoCollection coleccionVentas;

    private GestorVentas() {
        coleccionVentas = ConexionBD.getDatabase().getCollection("ventas", Venta.class);
    }

    public GestorVentas getInstance() {
        if (instance == null) {
            instance = new GestorVentas();
        }

        return instance;
    }

    @Override
    public Venta consultarVenta(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Venta> consultarVentasDeUsuario(Long usuarioId) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Venta> consultarVentasPorPeriodo(LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Venta> consultarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrarVenta(Venta venta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarVenta(Venta venta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarVenta(Long ventaId) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
