/*
 * GestorCompras.java
 */
package daos;

import com.mongodb.client.MongoCollection;
import conexion.ConexionBD;
import pojos.Compra;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class GestorCompras {

    private static GestorCompras instance;
    private final MongoCollection coleccionCompras;

    private GestorCompras() {
        coleccionCompras = ConexionBD.getDatabase().getCollection("compras", Compra.class);
    }

    public static GestorCompras getnstance() {
        if (instance == null) {
            instance = new GestorCompras();
        }

        return instance;
    }
}
