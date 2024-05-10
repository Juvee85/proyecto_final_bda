/*
 * Usuario.java
 */
package pojos;

import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class Usuario {

    private ObjectId id;  
    
    private String nombre;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String contrasenha;
    
    private String puesto;
    
    private String telefono;
    
    private LocalDate fechaContratacion;
    
    private Direccion direccion;
    
    private List<ObjectId> ventasRealizadas;
    
    public Usuario() {
        
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
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

    public List<ObjectId> getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(List<ObjectId> ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }
    
}
