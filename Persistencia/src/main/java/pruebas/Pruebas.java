/*
 * Pruebas.java
 */
package pruebas;

import daos.GestorProductos;
import daos.GestorUsuarios;
import excepciones.PersistenciaException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import pojos.Direccion;
import pojos.Producto;
import pojos.Puesto;
import pojos.Usuario;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        insertarGerente();
        insertarProductos();
    }

    public static void insertarGerente() {
        try {
            Usuario usuario = new Usuario();
            usuario.setRfc("QUTORJAZ12122002TG3D");
            usuario.setNombre("Jazmin");
            usuario.setApellidoPaterno("Quezada");
            usuario.setApellidoMaterno("Torres");
            usuario.setContrasenha(encriptar("admin"));
            usuario.setFechaContratacion(LocalDate.now());
            usuario.setTelefono("6441234567");
            usuario.setPuesto(Puesto.GERENTE);

            Direccion direccion = new Direccion();
            direccion.setCalle("7 de Mayo");
            direccion.setCiudad("Obregon");
            direccion.setColonia("Hidalgo");
            direccion.setCodigoPostal("85000");
            direccion.setNumeroEdificio("123");

            usuario.setDireccion(direccion);

            GestorUsuarios.getInstance().registrarUsuario(usuario);
        } catch (Exception ex) {

        }
    }

    public static void insertarProductos() {
        Producto producto = new Producto();

        producto.setCodigo("PROD1");
        producto.setNombre("Producto 1");
        producto.setStock(6);
        producto.setStockExceso(24);
        producto.setStockMinimo(6);
        producto.setPrecio(45f);

        Producto producto2 = new Producto();

        producto2.setCodigo("PROD2");
        producto2.setNombre("Producto 2");
        producto2.setStock(13);
        producto2.setStockExceso(30);
        producto2.setStockMinimo(8);
        producto2.setPrecio(39f);

        Producto producto3 = new Producto();

        producto3.setCodigo("PROD3");
        producto3.setNombre("Producto 3");
        producto3.setStock(25);
        producto3.setStockExceso(50);
        producto3.setStockMinimo(15);
        producto3.setPrecio(15f);

        try {
            GestorProductos.getInstance().registrarProducto(producto);
            GestorProductos.getInstance().registrarProducto(producto2);
            GestorProductos.getInstance().registrarProducto(producto3);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "8Fn3sJ1rKjDpGGsY";

    public static String encriptar(String valor) throws Exception {
        SecretKeySpec llave = generarLlave();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, (java.security.Key) llave);
        byte[] valorByteEncriptado = cipher.doFinal(valor.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(valorByteEncriptado);
    }

    public static String desencriptar(String valor) throws Exception {
        SecretKeySpec llave = generarLlave();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, (java.security.Key) llave);
        byte[] valor64Desencriptado = Base64.getDecoder().decode(valor);
        byte[] valorByteDesencriptado = cipher.doFinal(valor64Desencriptado);
        return new String(valorByteDesencriptado, "utf-8");
    }

    private static SecretKeySpec generarLlave() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
    }

}
