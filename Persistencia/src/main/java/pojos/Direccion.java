/*
 * Direccion.java
 */
package pojos;

/**
 * Clase POJO con la información necesaria para guardar la información de un
 * usuario o un proveedor del bazar
 *
 * @author Juventino López García - 00000248547
 */
public class Direccion {

    private String calle;

    private String colonia;

    private String ciudad;

    private String codigoPostal;

    private String numeroEdificio;

    /**
     * Constructor vacío por defecto
     */
    public Direccion() {
    }

    /**
     * Obtiene una cadena con la calle de la dirección
     *
     * @return Cadena con la calle de la dirección
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección a la cadena dada por el parámetro
     *
     * @param calle Cadena con la calle de la dirección
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene una cadena con la colonia de la dirección
     *
     * @return Cadena con la colonia de la dirección
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección a la cadena dada por el parámetro
     *
     * @param colonia Cadena con la colonia de la dirección
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene una cadena con la ciudad de la dirección
     *
     * @return Cadena con la ciudad de la dirección
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de la dirección a la cadena dada por el parámetro
     *
     * @param ciudad Cadena con la ciudad de la dirección
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene una cadena con el código postal de la dirección
     *
     * @return Cadena con el código postal de la dirección
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección a la cadena dada por el
     * parámetro
     *
     * @param codigoPostal Cadena con el código postal de la dirección
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene una cadena con el número de edificio de la dirección
     *
     * @return Cadena con el número de edificio de la dirección
     */
    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    /**
     * Establece el número de edificio de la dirección a la cadena dada por el
     * parámetro
     *
     * @param numeroEdificio Cadena con el número de edificio de la dirección
     */
    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

}
