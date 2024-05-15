/*
 * Usuario.java
 */
package pojos;

import java.time.LocalDate;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase con la información necesaria para guardar un usuario en la base de
 * datos
 *
 * @author Juventino López García - 00000248547
 */
public class Usuario {

    private ObjectId id;

    private String rfc;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String contrasenha;

    private Puesto puesto;

    private String telefono;

    private LocalDate fechaContratacion;

    private Direccion direccion;
    
    private Boolean eliminado;

    public Usuario() {

    }

    public Usuario(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasenha, Puesto puesto, String telefono, LocalDate fechaContratacion, Direccion direccion) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenha = contrasenha;
        this.puesto = puesto;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Document toDocument() {
        Document documento = new Document();
        documento.append("rfc", rfc);
        documento.append("nombre", nombre);
        documento.append("apellidoPaterno", apellidoPaterno);
        documento.append("apellidoMaterno", apellidoMaterno);
        documento.append("contrasenha", contrasenha);
        documento.append("puesto", puesto);
        documento.append("telefono", telefono);
        documento.append("fechaContratacion", fechaContratacion);
        documento.append("direccion", direccion);
        return documento;
    }

}
