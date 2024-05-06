/*
 * NegocioException.java
 */

package excepciones;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class NegocioException extends Exception {

    /**
     * Creates a new instance of <code>NegocioException</code> without detail message.
     */
    public NegocioException() {
    }


    /**
     * Constructs an instance of <code>NegocioException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NegocioException(String msg) {
        super(msg);
    }
}
