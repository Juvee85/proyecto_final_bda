/*
 * PresentacionException.java
 */
package excepciones;

/**
 *
 * @author Juventino López García - 00000248547 
 */
public class PresentacionException extends Exception {

    /**
     * Creates a new instance of <code>PresentacionException</code> without detail message.
     */
    public PresentacionException() {
    }


    /**
     * Constructs an instance of <code>PresentacionException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public PresentacionException(String msg) {
        super(msg);
    }
}
