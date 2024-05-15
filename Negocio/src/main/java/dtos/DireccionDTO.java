/*
 * DireccionDTO.java
 */
package dtos;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class DireccionDTO {

    private String calle;

    private String colonia;

    private String ciudad;

    private String codigoPostal;

    private String numeroEdificio;

    public DireccionDTO() {
    }

    public DireccionDTO(String calle, String colonia, String ciudad, String codigoPostal, String numeroEdificio) {
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.numeroEdificio = numeroEdificio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

}
