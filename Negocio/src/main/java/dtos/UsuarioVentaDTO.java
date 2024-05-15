/*
 * UsuarioVentaDTO.java
 */
package dtos;

/**
 * DTO con la informacon a almacenar en el registro de una venta sobre el
 * usuario que la realizó
 *
 * @author Juventino López García - 00000248547
 */
public class UsuarioVentaDTO {

    private String rfc;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    public UsuarioVentaDTO() {
    }

    public UsuarioVentaDTO(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

}
