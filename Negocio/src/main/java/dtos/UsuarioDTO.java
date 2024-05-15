/*
 * UsuarioDTO.java
 */
package dtos;

import pojos.Puesto;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class UsuarioDTO {

    private String rfc;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private Puesto puesto;

    private String contrasenha;

    private String telefono;

    private DireccionDTO direccion;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellidoPaterno, String apellidoMaterno, Puesto puesto) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
    }

    public UsuarioDTO(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, Puesto puesto, String contrasenha, String telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.contrasenha = contrasenha;
        this.telefono = telefono;
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

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

}
