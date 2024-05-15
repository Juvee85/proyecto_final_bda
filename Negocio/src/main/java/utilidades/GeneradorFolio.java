/*
 * GeneradorFolio.java
 */
package utilidades;
import java.util.Random;

/**
 * 
 * @author Juventino López García - 00000248547 
 */
public class GeneradorFolio {

    private static final String CARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generarFolio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int indice = random.nextInt(CARACTERES.length());
            char caracter = CARACTERES.charAt(indice);
            sb.append(caracter);
        }

        return sb.toString();
    }
}
