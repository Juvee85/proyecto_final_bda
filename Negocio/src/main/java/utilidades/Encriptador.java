/*
 * Encriptador.java
 */
package utilidades;

import excepciones.NegocioException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase para encriptar y desencriptar valores que requieran seguridad
 *
 * @author Juventino López García - 00000248547
 */
public class Encriptador {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "8Fn3sJ1rKjDpGGsY";

    /**
     * Método para encriptar valores
     *
     * @param valor Valor a encriptar
     * @return El valor encriptado
     * @throws NegocioException si sucede algún imprevisto
     */
    public static String encriptar(String valor) throws NegocioException {
        try {
            SecretKeySpec llave = generarLlave();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, (java.security.Key) llave);
            byte[] valorByteEncriptado = cipher.doFinal(valor.getBytes("utf-8"));
            return Base64.getEncoder().encodeToString(valorByteEncriptado);
        } catch (Exception e) {
            throw new NegocioException("Ocurrio un error al tratar de ingreasr");
        }

    }

    /**
     * Método para desencriptar valores
     *
     * @param valor Valor a desencriptar
     * @return El valor desencriptado
     * @throws NegocioException si sucede algún imprevisto
     */
    public static String desencriptar(String valor) throws NegocioException {
        try {
            SecretKeySpec llave = generarLlave();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, (java.security.Key) llave);
            byte[] valor64Desencriptado = Base64.getDecoder().decode(valor);
            byte[] valorByteDesencriptado = cipher.doFinal(valor64Desencriptado);
            return new String(valorByteDesencriptado, "utf-8");
        } catch (Exception e) {
            throw new NegocioException("Ocurrio un error al tratar de ingreasr");
        }

    }

    /**
     * Método para generar llaves secretas
     *
     * @return La llave secreta
     */
    private static SecretKeySpec generarLlave() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
    }
}
